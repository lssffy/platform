package com.sp.demo.util;

import java.io.*;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/28 22:07
 */
public class BeanCopy {

    public BeanCopy() {
        throw new AssertionError();
    }

    /**
     * 深拷贝
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        System.gc();
        Runtime.getRuntime().gc();
        return (T)ois.readObject();

    }
}
