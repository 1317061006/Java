package com.service;

import com.Dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * Created by han on 2016/9/7.
 */
@Repository
public class UserService {

     @Autowired
     UserDao userDao;

    public User getUserById(int id) {
       User user= userDao.getUserById(id);
        return user;
    }

    public User getUserByUsername(String username) {
        User user= userDao.getUserbyUsername(username);
        return user;
    }

    public  void SaveUser(User user){
        userDao.saveUser(user);
    }

    public  void deleteUser(int id){userDao.deleteUser(id);}

    public  void updateUser(User user){userDao.updateUser(user);}
 }
