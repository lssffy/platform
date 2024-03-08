package com.sp.demo.proxy;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/8 10:33
 */
public class Test {

    public static void main(String[] args) {
        OneDay oneDay = new LaoWang();
        oneDay.eat();
        System.out.println("================================");
        oneDay.play();
        System.out.println("================================");
        oneDay.sleep();
    }
}
