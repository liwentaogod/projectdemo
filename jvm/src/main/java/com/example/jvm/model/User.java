package com.example.jvm.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6622958117423426980L;

    private String name;

    private int  age;

    //
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
