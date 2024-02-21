package com.sp.framework.beans.config;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/29 23:20
 */
public class SBeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean,String beanName) { return bean;}

    public Object postProcessAfterInitialization(Object bean,String beanName) { return bean;}

}
