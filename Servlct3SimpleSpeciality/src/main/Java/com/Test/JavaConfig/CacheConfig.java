package com.Test.JavaConfig;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by han on 2016/12/11.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public EhCacheCacheManager cacheCacheManager(CacheManager em) {
        return new EhCacheCacheManager(em);
    }


    @Bean
    public EhCacheManagerFactoryBean ehcahe() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean =
                new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return  ehCacheManagerFactoryBean;
    }



}



