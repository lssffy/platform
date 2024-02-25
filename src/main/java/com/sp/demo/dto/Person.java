package com.sp.demo.dto;

import java.io.Serializable;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 16:20
 */
public class Person implements Serializable{

    private String name;
    private String sex;
    private int age;

    public Person() {
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


}
