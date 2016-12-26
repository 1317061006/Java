package com.Test.Dao.Spring_Data_JPA;

import com.Test.entity.County;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by han on 2016/12/1.
 */
public class CountyRepositoryImpl  implements CountySweeper{

     @PersistenceContext
     private EntityManager em;


    public List<County> selectAll() {
        String hql=" select new County(id,countryname)  from County";
       return em.createQuery(hql, County.class).getResultList();
    }

}
