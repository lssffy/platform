package com.sp.demo.proxy;

import com.sp.base.proxyhandler.SClassLoader;
import com.sp.base.proxyhandler.SInvocationHandler;
import com.sp.base.proxyhandler.SProxy;

import java.lang.reflect.Method;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 14:15
 */
public class InvocationHandlerJDK implements SInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> targetClass = target.getClass();
        return SProxy.newProxyInstance(new SClassLoader(),targetClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("start runtime invocation");
    }

    private void after(){
        System.out.println("end runtime invocation");
    }


}
