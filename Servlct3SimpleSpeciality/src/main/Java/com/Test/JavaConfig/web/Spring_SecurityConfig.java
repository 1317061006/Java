package com.Test.JavaConfig.web;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.JavaConfig.ConfigAssert.UserNoSqlServiceRepository;
import com.Test.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.*;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * 下列功能实现无错
 */
@Configuration
@EnableWebMvcSecurity//启动WevMvcSecurity功能
public class Spring_SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    RedisRepository repository;

    @Autowired
    AuthenticationService customUserDetailsService;


    //备用方案
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder())
                .usersByUsernameQuery("SELECT  username,password,enabled  FROM USERS WHERE  username=?")
                .authoritiesByUsernameQuery("SELECT  username,authority  FROM  authorities WHERE  username =?")
                .rolePrefix("ROLE_");//这样的前缀设置不建议使用  建议在Spring security对应的权限表使用权限全名


 //建议只使用一种验证角色方式  不然Remember me功能会出现无法验证的情况
        //以下注释内容单独使用情况也是成功的
//        auth
//                .inMemoryAuthentication()
////                .passwordEncoder(encoder())//admin
//                .withUser("admin").password("3013c4f63254e6f81c3c4a81ed598cedf7405d46c8e6fd8ce17c05a81b5ab566852d66cc436c772d").authorities("ROLE_USER", "ROLE_ADMIN")
//                .and()                      //ceshi
//                .withUser("ceshi").password("14b6ba891f34be4a28e609cefacf81265509a43d912f7e90a3c26bfa4c337652898e061c9e05d02d").roles("USER")
//                .and()                       //user
//                .withUser("user").password("6460233a3f4acdf69fb3d924f63f3ed6dcbe931deb826286f84929d4b909041a8e72c5e21b10c289").roles("USER")
//                .and()                     //liuziye
//                .withUser("liuziye").password("7671a416e8514aaabd50dfa38e5f835ed23d0cee0d90a102acaa0d0a07d8a1f0ed23dcfda8ef074d").roles("USER", "ADMIN");
//
//        auth
//                .userDetailsService(new UserNoSqlServiceRepository(repository));

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .successHandler(savedRequestAwareAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/logout")//如果实现的是Get请求进行退出 就必须实现如下配置 推荐POST请求方式进行退出
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/loggoutSuccess");

        //remember me功能
        http
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(1209600);


        http
                .httpBasic();
//                .realmName("test") //调用realmName()方法指定域


        http
                .csrf();


        http
                .authorizeRequests()
                .antMatchers("/register").hasAuthority("ROLE_USER")
                .antMatchers(HttpMethod.POST, "/register").hasAuthority("ROLE_ADMIN")
                .antMatchers("/file").hasRole("USER")
                .antMatchers("/order-api/**").hasRole("USER")
                .antMatchers("/ceshi/**").hasRole("USER")
                .antMatchers("County").permitAll()
                .antMatchers("/resources").permitAll()
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/ceshi").requiresInsecure();

        //session管理
        http
                .sessionManagement()
                .maximumSessions(2)
                .expiredUrl("/login");


    }



    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }





    /**
     * @return
     */
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
        auth.setTargetUrlParameter("login_success");
        return auth;
    }




}
