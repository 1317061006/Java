package com.Test.Dao.NOSQL.Redis;

import com.Test.entity.Order;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by han on 2016/12/12.
 */

public interface RedisRepository {

    public  Order  save(Order order);

//    @Cacheable(value = "userCache",key = "#result.key"
//    ,unless = "#result.message.contains('NOCache')"
////            ,condition = "#id >=10"
//    )

    @Cacheable(value = "userCache" ,key = "#key")
    public  Order find(String key);


    public  void  List(Order order);

    public Order List2();

    @CacheEvict("userCache")
    public void  remove(String key,Order order);

    public  void  Set(Order order);

    @CachePut(value = "userCache",key = "#orders.get(0).id")
    public  void bind(List<Order> orders) ;
}
