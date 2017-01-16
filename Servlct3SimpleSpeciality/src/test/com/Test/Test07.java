package com.Test;

import com.Test.JavaConfig.web.MybatisConfig;
import com.Test.Dao.mybatis.CountyMapper;
import com.Test.entity.County;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by han on 2016/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class Test07 {

    @Autowired
    CountyMapper countyMapper;


    @Test
    public void  Test(){
        System.out.println(countyMapper.selectAll());
    }


    @Test
    public  void Test2() {
        County county = new County();
        county.setId(2);
        System.out.println(countyMapper.selectOne(county));
    }


}
