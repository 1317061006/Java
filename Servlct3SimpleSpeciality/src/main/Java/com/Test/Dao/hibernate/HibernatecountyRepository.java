package com.Test.Dao.hibernate;

import com.Test.entity.County;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by han on 2016/12/1.
 */
@Repository
@Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED)
public class HibernatecountyRepository {

   private   SessionFactory sessionFactory;


    @Autowired              /*注入sessionFactory*/
    public HibernatecountyRepository(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    private Session currentSession() {
         Session session= sessionFactory.getCurrentSession();
         Transaction transaction = session.beginTransaction();
         return session;
    }

    private  Session openSession(){
        return sessionFactory.openSession();
    }

    private    void closeSession(Session session){
        session.close();
    }


    public County findone(int id){
         Session session=openSession();
        County county = (County) session.get(County.class, id);
        session.close();
        return county;
    }


    public  County findone2(int id){
        return (County) currentSession().get(County.class,id);
    }


}
