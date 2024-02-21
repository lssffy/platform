package com.sp.framework.context;

/**
 * @author : lssffy
 * @Description :通过解耦方式获得IOC容器的顶层设计，后面将通过一个监听器扫描所有的类，只要实现了此接口，将自动调用setApplicationContext()方法，从而将IOC容器注入到目标类中
 * @date : 2024/1/23 22:58
 */
public interface SApplicationContextAware{

    void setApplicationContext(SApplicationContext applicationContext);
}
