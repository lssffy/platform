package com.sp.framework.beans.config;

import lombok.Data;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/22 22:25
 */
@Data
public class SBeanDefinition {

    private String beanClassName;

    private boolean isLazyInit = false;

    private String factoryBeanName;

    private boolean isSingleton = true;


}
