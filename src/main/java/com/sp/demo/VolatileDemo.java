package com.sp.demo;

import org.junit.Test;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/16 18:42
 */
public class VolatileDemo {

    public volatile static boolean stop=false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
        VolatileDemo demo = new VolatileDemo();
        demo.MyTest();
    }

    public void MyTest(){
        MyRun myRun = new MyRun(100);
        myRun.run();
    }

     class MyRun implements Runnable {

        private Integer id;

        public MyRun(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < id; i++) {
                System.out.println(i);
            }
        }
    }

}


