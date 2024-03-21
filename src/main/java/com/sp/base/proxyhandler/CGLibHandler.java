package com.sp.base.proxyhandler;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 16:32
 */
public class CGLibHandler implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);
        after();
        return obj;
    }

    private void before(){
        System.out.println("before method");
    }

    private void after(){
        System.out.println("after method");
    }
}
