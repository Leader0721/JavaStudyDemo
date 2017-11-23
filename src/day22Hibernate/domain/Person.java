package day22Hibernate.domain;

import java.io.Serializable;

/**
 create database day22;
 use day22;
 create table PERSONS(
    ID int primary key,
    name varchar(255));







 *
 *
 *
 * Created by 83731 on 2017/11/23.
 */
public class Person implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
