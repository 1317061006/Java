package com.Test.service;

import com.Test.Dao.mybatis.CountyMapper;
import com.Test.entity.County;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by han on 2017/2/24.
 */
@Service
public class CountyService {

    @Autowired
    CountyMapper countyMapper;


    public County selectById(Integer id) {
      County county=  countyMapper.selectById(id);
        return county;
    }



}
