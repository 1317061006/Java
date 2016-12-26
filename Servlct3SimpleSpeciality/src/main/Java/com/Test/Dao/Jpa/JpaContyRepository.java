package com.Test.Dao.Jpa;

import com.Test.entity.County;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Created by han on 2016/12/1.
 */
@Repository
@Transactional
public class JpaContyRepository    {

    @PersistenceContext
    private EntityManager emf;


    public  County  findOne(int id){
        return emf.find(County.class,id);
    }


}
