package com.sp.demo.abstr;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 17:10
 */
public abstract class Bird {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}
