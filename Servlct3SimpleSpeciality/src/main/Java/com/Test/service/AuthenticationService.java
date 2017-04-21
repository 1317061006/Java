package com.Test.service;

import com.Test.Dao.mybatis.UsersMapper;
import com.Test.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by han on 2017/4/17.
 */
@Service
public class AuthenticationService  implements UserDetailsService {

    @Autowired
    private UsersMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ArrayList<UserInfo> userInfoList = (ArrayList<UserInfo>) userMapper.getUserInfo(username);
        List<GrantedAuthority> authorities =
                new ArrayList<GrantedAuthority>();
        for (int i = 0; i < userInfoList.size(); i++)
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userInfoList.get(i).getRole()));
        System.out.println(authorities);
        UserDetails userDetails = (UserDetails) new User(userInfoList.get(0).getName(),
                userInfoList.get(0).getPass(), authorities);

        return userDetails;
    }






}
