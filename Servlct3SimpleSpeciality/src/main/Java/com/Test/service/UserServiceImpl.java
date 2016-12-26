package com.Test.service;

import com.Test.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by han on 2016/12/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    @Secured("ROLE_ADMIN")
    public void TestSecured() {
        System.out.println("testSecured 含有 ROLE_ADMIN权限才能进行访问");
    }

    @Override
    @RolesAllowed("ROLE_USER")
    public void TestRoles_Allowed() {
        System.out.println("TestRoles_Allowed 含有 ROLE_USER 权限的才能进行访问");
    }


    @Override
    @PreAuthorize("hasRole('ROLE_USER') and #name.length() <=10" + "or hasRole('ROLE_ADMIN')")
    public void TestPreAuthorize(String name) {
        System.out.println("TestPreAuthorize方法 传入" + name + " -- name长度不该超过10 或有ADMIN权限");
    }

    @Override
    @PostAuthorize("returnObject.name ==principal.username")
    public User TestPostAuthorize(User user) {

        return user;
    }


    @Override
    @PostFilter("hasRole('ROLE_ADMIN') || filterObject.name == principal.name")
    public List<User> PostTestListUser() {
        User user = new User("username");
        User user2 = new User("user");
        User user3 = new User("User");
        User user4 = new User("ceshi");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return userList;
    }


    @Override
    @PreFilter("hasRole('ROLE_ADMIN') || filterObject.name ==principal.name")
    public void PreTestListUser(List<User> userList) {
        System.out.println("PreTestListUser方法");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PreFilter("hasPermission(targetObject ,'delete')")
    public  void  deleteUses(List<User> userList){

        for (int i = 0; i <userList.size() ; i++) {
            System.out.println(userList.get(i));
        }

    }

}
