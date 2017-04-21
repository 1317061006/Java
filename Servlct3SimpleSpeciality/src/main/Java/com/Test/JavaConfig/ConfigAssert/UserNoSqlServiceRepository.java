package com.Test.JavaConfig.ConfigAssert;

import com.Test.Dao.NOSQL.Redis.RedisRepository;
import com.Test.entity.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用NOSQL时 spring security查找的方式
 * Created by han on 2016/12/15.
 */
public class UserNoSqlServiceRepository implements UserDetailsService {

    private  final RedisRepository repository;

    public UserNoSqlServiceRepository(RedisRepository redisRepository) {
        this.repository = redisRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Order order =repository.find(username);
        if(order !=null) {
            List<GrantedAuthority> authorities =
                    new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new org.springframework.security.core.userdetails.User(
                    order.getId(),/*getId作为用户名 getCustomer作为密码*/
                    order.getCustomer(),authorities
            );
        }
        throw  new UsernameNotFoundException("User"+username+"not found");
    }


}
