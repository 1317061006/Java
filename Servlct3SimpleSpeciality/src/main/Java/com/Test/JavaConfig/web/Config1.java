package com.Test.JavaConfig.web;

import com.Test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import org.springframework.core.env.Environment;

/**
 * Created by han on 2016/11/19.
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("com.Test.Dao.JDBC")
public class Config1 {


    @Autowired
    Environment env;

    @Override
    public String toString() {
        return super.toString();
    }

    @Bean(name = "user")
    public User getUser() {
        return new User();
    }

     @Bean
     public DataSource dataSource() {
         DriverManagerDataSource ds = new DriverManagerDataSource();
         ds.setDriverClassName(env.getProperty("jdbc.driver"));
         ds.setUrl(env.getProperty("jdbc.url"));
         ds.setUsername(env.getProperty("jdbc.username"));
         ds.setPassword(env.getProperty("jdbc.password"));
         return ds;
     }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


      @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
          return new NamedParameterJdbcTemplate(dataSource);
      }


    /**
     * 这种配置messgae的方式可以进行更多的功能
     * 相比下面这种的好处是
     * 它可以定时刷新资源文件
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setCacheSeconds(10);
        return  messageSource;
    }


//  @Bean //第二种配置message的方式
//    public  MessageSource messageSource() {
//      ResourceBundleMessageSource messageSource =
//              new ResourceBundleMessageSource();
//      messageSource.setBasename("message");
//      return messageSource;
//  }


}
