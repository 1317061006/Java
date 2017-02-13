package com.Test.Dao.Spring_Data_JPA;

import com.Test.entity.County;

import java.util.List;

/**
 * Created by han on 2016/12/1.
 */
public interface CountySweeper {

   public List<County> selectAll();
}
