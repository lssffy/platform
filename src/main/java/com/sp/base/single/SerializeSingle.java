package com.sp.base.single;

import java.io.Serializable;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 16:25
 */
public class SerializeSingle implements Serializable {
    private SerializeSingle(){}
    private final static SerializeSingle serial = new SerializeSingle();
    public static SerializeSingle getInstance(){
        return serial;
    }
    private Object readResolve(){
        return serial;
    }
}
