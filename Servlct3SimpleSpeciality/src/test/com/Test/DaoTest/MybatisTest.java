package com.Test.DaoTest;

import com.Test.Dao.mybatis.CountyMapper;
import com.Test.Dao.mybatis.UsersMapper;
import com.Test.JavaConfig.web.MybatisConfig;
import com.Test.entity.UserInfo;
import com.Test.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by han on 2017/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = MybatisConfig.class)
public class MybatisTest {

    @Autowired
    CountyMapper countyMapper;

    @Autowired
    UsersMapper usersMapper;

    @Test
    public void usersTest() {
        ArrayList<UserInfo> usersArrayList = (ArrayList<UserInfo>) usersMapper.getUserInfo("users");
        for (int i = 0; i <usersArrayList.size() ; i++) {
            System.out.println(usersArrayList.get(i).getRole());
        }
    }


    @Test
    public void countytest() {
        System.out.println(  countyMapper.selectById(1));
    }
}
