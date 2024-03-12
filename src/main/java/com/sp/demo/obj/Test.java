package com.sp.demo.obj;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/12 12:02
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A d = new B();
        A e = new C();
        a = b;
//        b = c;
//        c = e;
//        c = (C)b;
        b = (B)d;
        c = (C)e;

        long text = 012;
        byte s = -128;
        double n = 0x123455;
        System.out.println(n);

        Integer i = 9;
        Integer j = 10;

        System.out.println(i==j);
        System.out.println(i.equals(j));

        byte[] h = "Z".getBytes();
        System.out.println(h[0]);

        boolean b1 = true;
        boolean b2 =false;
        if((b2=false)&&b1)
            System.out.println("122");
            System.out.println("122");

        int i1 = i + ~j;
        System.out.println(i1);
    }

}
