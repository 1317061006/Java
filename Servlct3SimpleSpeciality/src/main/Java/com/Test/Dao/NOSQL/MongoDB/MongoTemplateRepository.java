package com.Test.Dao.NOSQL.MongoDB;

import com.Test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by han on 2016/12/2.
 */
@Repository
public class MongoTemplateRepository {


    @Autowired
     private   MongoOperations mongo;


    public void save(Order order) {
        mongo.save(order);
    }


    public long count(String name) {

        return mongo.getCollection(name).count();
    }
}
