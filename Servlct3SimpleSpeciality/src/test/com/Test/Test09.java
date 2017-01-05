package com.Test;

import com.Test.JavaConfig.TestConfig;
import com.Test.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by han on 2016/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class Test09 {


    @Autowired
    Item item;

    @Autowired
    Item item2;

    @Test
    public  void test(){
        System.out.println(item);
        System.out.println(item2);
    }







}
