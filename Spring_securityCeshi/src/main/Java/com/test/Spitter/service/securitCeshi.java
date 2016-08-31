package com.test.Spitter.service;

import com.test.Spitter.entity.user;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by han on 2016/8/7.
 */
public class securitCeshi implements  isecuritCeshi {

    public void ceshi1() {
        System.out.println("ceshi1 无参");
    }

    /* @Secured({"ROLE_USER","ROLE_ADMIN"})*/
   /*@RolesAllowed("ROLE_ADMIN")*/
 /*   @PreAuthorize("(hasRole('ROLE_USER') and #s.length() <=10) " +
            "or hasRole('ROLE_ANONYMOUS')")*/
    @PostAuthorize("(returnObject == principal.username) or hasRole('ROLE_ADMIN')")
    public  String ceshi1(String s) {
        System.out.println("ceshi1 有参" + s);
        return s;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostFilter("filterObject.id == 10")
    public user ceshi1(int d) {
        System.out.println(d);
        user u = new user();
        u.setId(d);
        return u;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostFilter("filterObject.id == 20")
    public List<user> ceshi2(int d) {
        List<user> list = new ArrayList<user>();
        System.out.println(d);
        user u = new user();
        user u2 = new user();
        u.setId(d);
        u2.setId(20);
        list.add(u);
        list.add(u2);
        return list;
    }

    public  void ceshi2(){
        System.out.println("ceshi2");
    }


}
