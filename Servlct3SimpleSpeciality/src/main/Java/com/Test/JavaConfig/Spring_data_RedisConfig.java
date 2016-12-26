package com.Test.JavaConfig;

import com.Test.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by han on 2016/12/4.
 */
@Configuration
@ComponentScan("com.Test.Dao.NOSQL.Redis")
public class Spring_data_RedisConfig {


    @Bean
    public RedisConnectionFactory redisCF() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        return cf;
    }


    @Bean
    public RedisTemplate<String,Order>redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Order> redis = new RedisTemplate<String, Order>();
        redis.setConnectionFactory(redisCF());
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Order>(Order.class));
        return redis;
    }


}
