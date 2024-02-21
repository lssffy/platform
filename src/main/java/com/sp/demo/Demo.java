package com.sp.demo;

import org.junit.Test;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/16 18:02
 */
public class Demo {
    private static int count = 0;
    public static void inc(){
        synchronized (Demo.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000;i++){
            new Thread(()->Demo.inc()).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果：" + count);
        TestIng testIng = new TestIng();
        testIng.testPrint();
    }


}
