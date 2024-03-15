package com.sp.base.single;

/**
 * @author : lssffy
 * @Description : 静态代码块 饿汉式单例
 * @date : 2024/3/13 15:47
 */
public class HungryStaticSingle {

    private static final HungryStaticSingle hungryStaticSingle;

    static {
        hungryStaticSingle = new HungryStaticSingle();
    }

    private HungryStaticSingle(){}

    public HungryStaticSingle getInstance(){
        return hungryStaticSingle;
    }
}
