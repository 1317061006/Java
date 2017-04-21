package com.Test.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by han on 2017/4/17.
 */
@Table(name = "users")
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private Boolean enabled;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
