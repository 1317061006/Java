package com.Dao;

import com.entity.county;
import com.github.pagehelper.PageHelper;
import com.inter.CountyOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by han on 2016/11/25.
 */
@Repository("countyDao")
public class countyDao {

    @Autowired
    CountyOperation countyOperation;



    public List<county> selectAll(int pagenum,int pagerow){
        PageHelper.startPage(pagenum, pagerow);
     return    countyOperation.selectAll();
    }


}
