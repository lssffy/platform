package com.sp.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/8 10:27
 */
public class MyInvocationHandler implements InvocationHandler {

    private LaoWang laoWang = new LaoWang();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        method.invoke(laoWang);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间:" + (endTime-startTime));
        return null;
    }
}
