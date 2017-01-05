package com.Test.service;

import com.Test.entity.User;

import java.util.List;

/**测试SpirngSecurity 安全注解
 * Created by han on 2016/12/17.
 */
public interface UserService {

 void TestSecured();

 void TestRoles_Allowed();

 void TestPreAuthorize(String name);

 User TestPostAuthorize(User user);

 List<User> PostTestListUser();

 void PreTestListUser(List<User> userList);


 void  deleteUses(List<User> userList);
}
