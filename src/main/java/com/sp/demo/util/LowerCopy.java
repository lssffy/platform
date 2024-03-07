package com.sp.demo.util;

import lombok.Data;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/28 22:12
 */
@Data
public class LowerCopy implements Cloneable{

    private Object objects;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
