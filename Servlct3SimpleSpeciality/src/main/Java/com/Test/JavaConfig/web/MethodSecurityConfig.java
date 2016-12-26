package com.Test.JavaConfig.web;

import com.Test.JavaConfig.Test.UserPermissionEvaluator;
import com.Test.service.UserService;
import com.Test.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by han on 2016/12/17.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = false)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication();

    }


    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }



    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler experssionHandler =
                new DefaultMethodSecurityExpressionHandler();
        experssionHandler.setPermissionEvaluator(
                new UserPermissionEvaluator()
        );
        return  experssionHandler;
    }


}
