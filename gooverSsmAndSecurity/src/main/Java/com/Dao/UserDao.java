package com.Dao;

import com.entity.User;
import com.inter.IUserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by han on 2016/9/7.
 */
@Repository
public class UserDao {


     @Autowired
    IUserOperation mapper;



    public   User getUserById(int id) {

          User user=mapper.selectUserByID(id);
          return user;
      }


    public  void  saveUser(User user){
        mapper.addUser(user);
    }


    public User getUserbyUsername(String username) {
        User user = mapper.selectUserbyUsername(username);
        return user;
    }


    public  void  deleteUser(int id){
           mapper.deleteUser(1);
    }

    public void updateUser(User user){
          mapper.updateUser(user);
    }

}
