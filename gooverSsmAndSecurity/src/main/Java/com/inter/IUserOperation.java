package com.inter;



import com.entity.User;

import java.util.List;

/**
 * Created by han on 2016/8/25.
 */
public interface IUserOperation {
    public User selectUserByID(int id);
    public List<User> selectUsers(String userName);

    public  void addUser(User user);

    public void updateUser(User user);

    public  void deleteUser(int id);

    public User selectUserbyUsername(String username);


}
