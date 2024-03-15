package com.sp.base.single;

/**
 * @author : lssffy
 * @Description : 静态内部类
 * @date : 2024/3/13 16:05
 */
public class LazyInnerSingle {

    private LazyInnerSingle(){
//        if(LazyInnerHolder.lazy!=null){
//            throw new RuntimeException("不能创建多个实例");
//        };
    }

    public static final LazyInnerSingle getInstance(){
        return LazyInnerHolder.lazy;
    }

    private static class LazyInnerHolder{
        private static final LazyInnerSingle lazy = new LazyInnerSingle();
    }
}
