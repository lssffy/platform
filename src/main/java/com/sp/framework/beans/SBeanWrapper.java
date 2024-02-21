package com.sp.framework.beans;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/24 23:01
 */
public class SBeanWrapper {

    private Object wrappedInstance;
    private Class<?> wrapperClass;

    public SBeanWrapper(Object wrappedInstance){
        this.wrappedInstance = wrappedInstance;
    }

    public Class<?> getWrapperClass(){
        return this.wrappedInstance.getClass();
    }

    public Object getWrappedInstance() {
        return wrappedInstance;
    }
}
