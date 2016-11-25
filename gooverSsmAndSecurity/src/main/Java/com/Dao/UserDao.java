package com.Dao;

import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.inter.IUserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by han on 2016/9/7.
 */
@Repository
public class UserDao {


     @Autowired
    IUserOperation mapper;


    //对于使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
    //如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
    //不指定key时，使用默认的key生成策略KeyGenerator。
    //方法没有参数时，使用SimpleKey.EMPTY
    //只有一个参数时，使用该参数作为key
    //多于一个参数时，使用包含所有参数的SimpleKey（所有参数的hashCode）
    @Cacheable("userCache")
    public   User getUserById(int id) {

          User user=mapper.selectUserByID(id);
          return user;
      }


    //与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
    //而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
   @CachePut(value = "userCache",key = "#user.id")
    public  void  saveUser(User user){
        mapper.addUser(user);
    }

    @Cacheable("userCache")
    public List<User> selectUsers(String userName,int pagenum,int pagerow) {
        PageHelper.startPage(pagenum, pagerow);
        List<User> users = mapper.selectUsers(userName);
        return users;
    }


    @Cacheable("userCache")
    public User getUserbyUsername(String username) {
        User user = mapper.selectUserbyUsername(username);
        return user;
    }

    //@CacheEvict移除cache中相应的缓存项，evict操作默认在方法返回时进行，如果方法执行中抛出异常，则evict操作不会发生。
    //beforeInvocation=true表示在方法调用之前先进行cache的evict操作，allEntries=true表示清除所有的缓存项。
    @CacheEvict("userCache")
    public  void  deleteUser(int id){
           mapper.deleteUser(1);
    }



    @CachePut(value = "userCache",key = "#user.id")
    public void updateUser(User user){
          mapper.updateUser(user);
    }


}
