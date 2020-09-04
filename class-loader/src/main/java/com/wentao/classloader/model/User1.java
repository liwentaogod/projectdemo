package com.wentao.classloader.model;

import java.io.Serializable;

public class User1 implements Serializable {

    private static final long serialVersionUID = -6622958117423426980L;

    private String name;

    private int  age;

    //
    private String telephone;


    static {

        System.out.println("加载 user1 类");
    }

    public String sout(){
        System.out.println("打印数据1");
        return null;
    }


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
