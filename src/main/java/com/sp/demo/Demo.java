package com.sp.demo;

import com.sp.demo.dto.Person;
import com.sp.demo.service.Apple;
import com.sp.demo.util.FruitInfoUtil;

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
        try {
            Class clazz = Class.forName("com.sp.demo.dto.Person");
            Person p = (Person) clazz.newInstance();
            Constructor constructor = clazz.getDeclaredConstructor(String.class,String.class,int.class);
            Person p1 = (Person) constructor.newInstance("老王","男",35);
            String name = "";
            String id = "22";
            if((name!="")||(id!="")){
                System.out.println("23333");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer c = 100;
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        System.out.println(a==b);
        System.out.println(a.equals(c));

        FruitInfoUtil.getFruitInfo(Apple.class);


    }


}
