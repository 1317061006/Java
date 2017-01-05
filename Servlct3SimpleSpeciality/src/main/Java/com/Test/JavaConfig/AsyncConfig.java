package com.Test.JavaConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by han on 2016/12/28.
 */
@Configuration
@EnableAsync
@ComponentScan("com.Test.JavaConfig.Test.Async")
public class AsyncConfig {


}
