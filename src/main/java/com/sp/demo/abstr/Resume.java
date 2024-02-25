package com.sp.demo.abstr;

import com.sp.demo.dto.Person;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 17:42
 */
public class Resume implements Cloneable{
    String name;
    int age;
    Person p;

    Resume(String name, int age, Person p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    public Object clone() throws CloneNotSupportedException {
        Resume r = null;
        r = (Resume) super.clone();
        return r;
    }
}
