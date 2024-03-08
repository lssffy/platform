package com.sp.demo.lambda;

import org.junit.Test;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/8 14:28
 */
public class LamdbaTest {
    @Test
    public void test(){
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "Running1111");
            }
        };
        new Thread(r).start();
    }


    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "Running1111");
                }
            }).start();
        }
    }

    @Test
    public void test2(){
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "Running1111");
            }).start();
        }
    }
}
