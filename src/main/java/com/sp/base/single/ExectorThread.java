package com.sp.base.single;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 15:53
 */
public class ExectorThread implements Runnable {
    @Override
    public void run() {
//        LazySingle lazySingle = LazySingle.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + lazySingle);
        LazyInnerSingle innerSingle = LazyInnerSingle.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + innerSingle);
    }
}
