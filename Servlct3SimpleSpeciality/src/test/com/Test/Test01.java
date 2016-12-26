package com.Test;

import com.Test.Dao.JDBC.JDBCUserRepository;
import com.Test.entity.County;
import com.Test.JavaConfig.web.Config1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by han on 2016/11/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config1.class)
public class Test01 {

   @Autowired
    JDBCUserRepository jdbcUserRepository;

    @Test
    public void test01(){
        System.out.println(jdbcUserRepository.findone(2));
    }

    @Test
    public  void test02(){
        jdbcUserRepository.addcountry(new County(2,"222","2321"));
    }
}
