package com.Test.JavaConfig.web;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.JavaConfig.Test.UserNoSqlServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import javax.sql.DataSource;

/**
 * Created by han on 2016/11/29.
 */
@Configuration
@EnableWebMvcSecurity//启动WevMvcSecurity功能
public class Spring_SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    RedisRepository repository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT  username,password,enabled  FROM USERS WHERE  username=?")
                .authoritiesByUsernameQuery("SELECT  username,authority  FROM  authorities WHERE  username =?")
                .rolePrefix("ROLE_");


        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN")
                .and()
                .withUser("ceshi").password("ceshi").roles("USER")
                .and()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("1317061006").password("liuziye").roles("USER", "ADMIN");

        auth
                .userDetailsService(new UserNoSqlServiceRepository(repository));

    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                   .loginPage("/login")
                .and()
                .logout()
                   .logoutSuccessUrl("/")
                .and()
                .rememberMe()
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                .tokenValiditySeconds(2419200)
                .key("testKey")
                .and()
                .httpBasic()
//                .realmName("test") //调用realmName()方法指定域
                .and()
                .authorizeRequests()
                .antMatchers("/register").hasAuthority("ROLE_USER")
                .antMatchers(HttpMethod.POST,"/register").hasAuthority("ROLE_ADMIN")
                .antMatchers("/file").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/ceshi").requiresInsecure();//不需要https


    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }




}
