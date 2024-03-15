package com.sp.base.single;

/**
 * @author : lssffy
 * @Description : 懒汉式单例
 * @date : 2024/3/13 15:51
 */
public class LazySingle {
    private LazySingle(){}
    private static LazySingle lazySingle = null;
    public static LazySingle getInstance(){
        if(null == lazySingle){
            synchronized (LazySingle.class){
                if(null == lazySingle) {
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }
}
