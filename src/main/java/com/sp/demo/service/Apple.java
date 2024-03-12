package com.sp.demo.service;

import com.sp.demo.util.FruitProvider;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 16:51
 */
public class Apple {

    public String name = "aaa";

    @FruitProvider(id=1,name="2222",address = "333333")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
