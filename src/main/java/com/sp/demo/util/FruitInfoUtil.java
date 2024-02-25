package com.sp.demo.util;

import java.lang.reflect.Field;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 16:52
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){
        String strFruitProvider = "信息";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields
             ) {
            if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = "编号" + fruitProvider.id() + "名称" + fruitProvider.name() +
                        "地址" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }

}
