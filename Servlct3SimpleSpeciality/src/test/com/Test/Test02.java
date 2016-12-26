package com.Test;

import com.Test.Dao.hibernate.HibernatecountyRepository;
import com.Test.JavaConfig.HibernateDataConfig1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by han on 2016/12/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateDataConfig1.class)
public class Test02 {


    @Autowired
    private HibernatecountyRepository hibernatecountyRepository;



    @Test
    public void test1(){
          System.out.println(hibernatecountyRepository.findone(1));
        System.out.println(hibernatecountyRepository.findone2(2));
         }



}
