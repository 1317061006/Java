package com.Test.Dao.NOSQL.MongoDB;

import com.Test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by han on 2016/12/4.
 */
public class MongonDBRepositoryImpl implements OrderOperations {

    @Autowired
    private MongoOperations mongo;


    public List<Order> findOrderByType(String t) {
     String type=t.equals("NET")? "WEB" :t;
        Criteria where=Criteria.where("type").is(t);
        Query query= Query.query(where);
         return mongo.find(query,Order.class);
    }
}
