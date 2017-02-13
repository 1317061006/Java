package com.Test.AsyncTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by han on 2016/12/28.
 */
@Configuration
@EnableAsync
public class AsyncConfig {


    @Bean
    public Task task() {
        return new Task();
    }

}
