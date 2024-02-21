package com.sp.framework.beans.support;

import com.sp.framework.beans.config.SBeanDefinition;
import com.sp.framework.context.support.SAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/22 22:22
 */
public class SDefaultListableBeanFactory extends SAbstractApplicationContext {

    protected final Map<String, SBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,SBeanDefinition>();

}
