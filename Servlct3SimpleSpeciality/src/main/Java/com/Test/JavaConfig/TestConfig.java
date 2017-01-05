package com.Test.JavaConfig;

import com.Test.entity.Item;
import com.Test.entity.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by han on 2016/12/13.
 */
@Configuration
public class TestConfig {



    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Item item() {
        return new Item();
    }


}
