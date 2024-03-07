package com.sp.demo.service;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/28 21:24
 */
public abstract class AppleAbstractService {


    private  Object object = new Object();

    public AppleAbstractService() {
        object = new Object();
        System.out.println(object.getClass().getName());
    }

    public AppleAbstractService(Object object) {
        this.object = object;
        System.out.println(object.getClass().getName());
    }
}
