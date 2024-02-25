package com.sp.demo;

import com.sp.demo.dto.Person;
import com.sp.demo.service.Apple;
import com.sp.demo.util.FruitInfoUtil;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/16 18:02
 */
public class Demo {
    private static int count = 0;
    public static void inc(){
        synchronized (Demo.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 1000;i++){
//            new Thread(()->Demo.inc()).start();
//        }
//        Thread.sleep(3000);
//        System.out.println("运行结果：" + count);
        try {
            Class clazz = Class.forName("com.sp.demo.dto.Person");
            Person p = (Person) clazz.newInstance();
            Constructor constructor = clazz.getDeclaredConstructor(String.class,String.class,int.class);
            Person p1 = (Person) constructor.newInstance("老王","男",35);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FruitInfoUtil.getFruitInfo(Apple.class);
    }


}
