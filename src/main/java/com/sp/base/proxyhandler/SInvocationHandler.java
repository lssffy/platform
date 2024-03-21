package com.sp.base.proxyhandler;

import java.lang.reflect.Method;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 14:41
 */
public interface SInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
