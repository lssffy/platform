package com.sp.base.single;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author : lssffy
 * @Description : 测试
 * @date : 2024/3/13 15:54
 */
public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("end");
        //反射破坏单例
        try {
            Class<?> clazz = LazyInnerSingle.class;

            Constructor c = clazz.getDeclaredConstructor(null);

            c.setAccessible(true);

            Object o1 = c.newInstance();

            Object o2 = c.newInstance();

            System.out.println(o1==o2);

        }catch (Exception e) {
            e.printStackTrace();
        }
        //序列化破坏单例
        SerializeSingle single1 = null;
        SerializeSingle single2 = SerializeSingle.getInstance();

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("SerializeSingle.obj1");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(single2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializeSingle.obj1");
            ObjectInputStream ois = new ObjectInputStream(fis);
            single1 = (SerializeSingle) ois.readObject();
            ois.close();
            System.out.println(single1);
            System.out.println(single2);
            System.out.println(single1==single2);
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //枚举登记 注册式单例
            EnumSingle enumSingle1 = null;
            EnumSingle enumSingle2 = EnumSingle.getInstance();
            enumSingle2.setObject(new Object());

            FileOutputStream fos1 = new FileOutputStream("EnumSingle.object");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(enumSingle2);
            oos1.flush();
            oos1.close();

            FileInputStream fis1 = new FileInputStream("EnumSingle.object");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            enumSingle1 = (EnumSingle) ois1.readObject();
            ois1.close();

            System.out.println(enumSingle1);
            System.out.println(enumSingle2);
            System.out.println(enumSingle1==enumSingle2);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(ThreadLocalSingle.getInstance());
        System.out.println(ThreadLocalSingle.getInstance());
        System.out.println(ThreadLocalSingle.getInstance());
        System.out.println(ThreadLocalSingle.getInstance());
        System.out.println(ThreadLocalSingle.getInstance());



    }
}
