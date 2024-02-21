package com.sp.framework.beans;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/22 22:08
 */
public interface SBeanFactory {

    /**
     * 根据beanName从IOC容器中获取一个实例bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
