package com.Test;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.JavaConfig.web.Spring_data_RedisConfig;
import com.Test.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by han on 2016/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Spring_data_RedisConfig.class)
public class Test06 {

    @Autowired
    RedisRepository repository;

    @Test
    public void Test01() {
        Order order = new Order();
        order.setId("1");
        order.setCustomer("Test");
        order.setType("ceshi");
        repository.save(order);
    }

    @Test
    public void Test02() {
        Order order = new Order();
        repository.List(order);
    }

    @Test
    public void Test03() {
        Order order = new Order();
        System.out.println(repository.List2());
    }


    @Test
    public  void findOneTest(){
        Order order=repository.find("username");
        System.out.println(order);
    }


    @Test
    public  void removeOrder() {
        repository.remove("2");
    }



}
