package com.Test;
/*Dao层测试*/
import com.Dao.UserDao;
import com.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by han on 2016/11/3.
 */
public class MybatisTest {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationcontext.xml");
         UserDao userDao= (UserDao) context.getBean("userDao");
        System.out.println(userDao.getUserById(1));
        List<User> users = userDao.selectUsers("ceshi", 1, 2);

        for (int i=0;i<users.size();i++){
            System.out.println(users.get(i));
        }

    }
}
