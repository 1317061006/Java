package com.Test;

import com.Test.Dao.Spring_Data_JPA.CountyRepository;
import com.Test.JavaConfig.Spring_data_jpaConfig;
import com.Test.entity.County;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by han on 2016/12/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Spring_data_jpaConfig.class)
public class Test04 {

    @Autowired
    CountyRepository countyRepository;

    @Test
    public void Test1() {
        System.out.println(countyRepository.findBycountryname("ceshi"));
        System.out.println(countyRepository.ceshi(1));
        System.out.println("--------------");
        List<County> list = countyRepository.selectAll();
        System.out.println(countyRepository.selectAll());
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println(countyRepository.findOne(1));
    }

}
