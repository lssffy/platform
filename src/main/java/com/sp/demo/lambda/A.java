package com.sp.demo.lambda;


/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/8 15:12
 */
@FunctionalInterface
public interface A {
    void method();

    default void method1(){
        System.out.println("method默认方法");
    }

    static void method2(){
        System.out.println("method静态方法");
    }
}
