package com.sp.base.simple;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 14:59
 */
public class SimpleFactory {
    public ICourse getInstance(String name) {
        try {
            if(!(null==name||"".equals(name))){
                return (ICourse) Class.forName(name).newInstance();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ICourse createInstance(Class<? extends ICourse> clazz) {
        try {
            if(clazz!=null){
               return clazz.newInstance();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
