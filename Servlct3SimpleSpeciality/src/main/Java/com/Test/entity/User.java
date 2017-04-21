package com.Test.entity;

import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by han on 2016/11/19.
 */
@PropertySource("classpath:ValidationMessages.properties")
public class User {

    @NotNull
    @Size(min = 2,max = 20,message ="{User.name.size}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }


    public User(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }


}
