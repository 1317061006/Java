package com.Test.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by han on 2016/12/1.
 */
@Entity
public class County {
    private int id;
    private String countryname;
    private String countrycode;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public County() {
    }

    public County(int id, String countryname, String countrycode) {
        this.id = id;
        this.countryname = countryname;
        this.countrycode = countrycode;
    }

    @Basic
    @Column(name = "countryname", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCountryname() {
        return countryname;
    }


    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    @Basic
    @Column(name = "countrycode", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        County county = (County) o;
        return Objects.equals(id, county.id) &&
                Objects.equals(countryname, county.countryname) &&
                Objects.equals(countrycode, county.countrycode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryname, countrycode);
    }


    public County(int id, String countryname) {
        this.id = id;
        this.countryname = countryname;
    }

    @Override
    public String toString() {
        return "County{" +
                "id=" + id +
                ", countryname='" + countryname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }
}
