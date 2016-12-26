package com.Test;

import com.Test.Dao.NOSQL.MongoDB.MongoTemplateRepository;
import com.Test.Dao.NOSQL.MongoDB.MongonDBRepository;
import com.Test.JavaConfig.Spring_data_MongonConfig;
import com.Test.entity.Item;
import com.Test.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by han on 2016/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Spring_data_MongonConfig.class)
public class Test05 {

     @Autowired
     MongoTemplateRepository mongo;


     @Autowired
     MongonDBRepository mongo2;



    @Test
    public void Test() {
        Order order = new Order();
        order.setCustomer("testCustomer");
        order.setType("ceshiType");
        mongo2.save(order);
    }


    @Test
    public void Test2() {

        List<Order> orderList = mongo2.findtestCustomerOrders("ceshiType");
        for (int i = 0; i <orderList.size() ; i++) {
            System.out.println(orderList.get(i));
        }
    }


    @Test
    public  void test() {
        Order order = new Order();
        order.setType("ceshi2Type");
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item());
        order.setItems(items);
        mongo.save(order);
    }

    @Test
    public  void test3() {
        System.out.println(mongo.count("order"));
    }

}
