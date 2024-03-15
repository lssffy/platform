package com.sp.base.single;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 16:41
 */
public enum EnumSingle {
    INSTANCE;

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static EnumSingle getInstance(){
        return INSTANCE;
    }

}
