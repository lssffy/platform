package com.sp.base.single;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : lssffy
 * @Description : 容器缓存
 * @date : 2024/3/13 17:28
 */
public class ContainerSingle {
    private ContainerSingle(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getBean(String className){
        synchronized (ioc) {
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }
}
