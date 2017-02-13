package com.Test.Dao.NOSQL.MongoDB;

import com.Test.entity.Order;

import java.util.List;

/**
 * Created by han on 2016/12/4.
 */
public interface OrderOperations {

 public List<Order> findOrderByType(String t);

}
