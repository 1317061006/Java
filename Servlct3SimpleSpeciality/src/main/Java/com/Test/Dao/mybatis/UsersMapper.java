package com.Test.Dao.mybatis;

import com.Test.entity.UserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by han on 2017/4/17.
 */
public interface UsersMapper extends Mapper<UserInfo> {

    public List<UserInfo> getUserInfo(String username);

}
