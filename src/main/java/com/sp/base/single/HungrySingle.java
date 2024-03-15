package com.sp.base.single;

/**
 * @author : lssffy
 * @Description : 饿汉式单例
 * @date : 2024/3/13 15:45
 */
public class HungrySingle {
    private static final HungrySingle httpSingle = new HungrySingle();

    private HungrySingle(){}

    private static HungrySingle getInstance(){
        return httpSingle;
    }
}
