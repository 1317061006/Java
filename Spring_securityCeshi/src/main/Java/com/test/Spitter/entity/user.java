package com.test.Spitter.entity;

/**
 * Created by han on 2016/8/7.
 */
public class user {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                '}';
    }
}
