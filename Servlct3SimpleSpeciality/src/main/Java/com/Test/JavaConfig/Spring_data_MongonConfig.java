package com.Test.JavaConfig;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Created by han on 2016/12/2.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.Test.Dao.NOSQL.MongoDB")
//@PropertySource("classpath:mongondb.properties")
@ComponentScan("com.Test.Dao.NOSQL.MongoDB")
public class Spring_data_MongonConfig extends AbstractMongoConfiguration {


    @Override// 返回数据库名称
    protected String getDatabaseName() {//指定数据库名称
        return "OrdersDB";
    }

    @Autowired
    private Environment env;


//    @Override
//    public Mongo mongo() throws Exception {
//
//        MongoCredential credential=
//                MongoCredential.createCredential(
//                        env.getProperty("mongo.username")
//                        ,"OrderDB"
//                        ,env.getProperty("mongo.passowrd").toCharArray()
//                );
//        return new MongoClient(new ServerAddress("localhost",27017),
//                Arrays.asList(credential));
//    }


    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

}
