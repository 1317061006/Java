package com.Test;

import com.Test.Dao.Jpa.JpaContyRepository;
import com.Test.JavaConfig.JPADataConfig2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by han on 2016/12/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JPADataConfig2.class)
public class Test03 {

    @Autowired
    JpaContyRepository jpaContyRepository;

    @Test
    public  void test01(){
        System.out.println(jpaContyRepository.findOne(1));
    }



}
