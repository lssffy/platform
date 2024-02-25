package com.sp.demo.dto;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 17:01
 */
public class Out {
    private static int a;
    private int b;

    public void test(final int c){
        final int d = 1;
        class inner{
            public void print(){
                System.out.println(c);
            }
        }
    }
}
