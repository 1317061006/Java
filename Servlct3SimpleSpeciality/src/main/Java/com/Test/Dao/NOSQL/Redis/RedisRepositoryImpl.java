package com.Test.Dao.NOSQL.Redis;

import com.Test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by han on 2016/12/4.
 */
@Repository
public class RedisRepositoryImpl implements RedisRepository  {

    @Autowired
    RedisTemplate redisTemplate;

     public  Order  save(Order order){
            redisTemplate.opsForValue().set(order.getId(), order);
         return order;
   }


    @Override
    public Order find(String key) {
        Order order = (Order) redisTemplate.opsForValue().get(key);
        return order;
    }


    /**
     * List类型的条目尾部添加一个值
     */
    public  void  List(Order order){
        redisTemplate.opsForList().rightPush("cartRight", order);
        redisTemplate.opsForList().leftPush("cartLeft", order);
    }


     public Order List2(){
         Order order1 = (Order) redisTemplate.opsForList().leftPop("cartLeft");
         Order order2 = (Order) redisTemplate.opsForList().rightPop("cartRight");
         List<Order> list=redisTemplate.opsForList().range("cart", 1, 10);
         return order1;
     }

    @Override
    public void remove(String key,Order order) {
        redisTemplate.opsForSet().remove(key,order);
    }


    public  void  Set(Order order){
        redisTemplate.opsForSet().add("cart", order);
        redisTemplate.opsForSet().add("cart1", order);
        redisTemplate.opsForSet().add("cart2", order);
        Set<Order> diff2 = (Set<Order>) redisTemplate.opsForSet().union("cart", "cart2");
        Long diff3 = redisTemplate.opsForSet().remove("cart", order);
        Object diff4 =  redisTemplate.opsForSet().randomMember("cart1");
        Long diff5 = redisTemplate.opsForSet().remove("cart1", order);
        Long diff6 = redisTemplate.opsForSet().remove("cart2", order);
    }




    public  void bind(List<Order> orders) {
        BoundListOperations<String, Order> cart = redisTemplate.boundListOps("cart");
        cart.rightPush(orders.get(0));
        cart.rightPush(orders.get(1));
        cart.rightPush(orders.get(2));
    }



}
