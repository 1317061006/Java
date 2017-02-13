package com.Test.Dao.NOSQL.MongoDB;

import com.Test.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by han on 2016/12/2.
 */
public interface MongonDBRepository extends MongoRepository<Order,String> ,OrderOperations{



     @Query("{'customer':'testCustomer'},'type':?0")
   public   List<Order>findtestCustomerOrders(String t);

}
