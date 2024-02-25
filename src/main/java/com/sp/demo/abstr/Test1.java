package com.sp.demo.abstr;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 17:11
 */
public class Test1 {
    public void test1(Bird bird){
        System.out.println(bird.getName() + "飞" + bird.fly() + "米");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test1(new Bird() {
            @Override
            public int fly() {
                return 1000;
            }

            @Override
            public String getName() {
                return "家禽";
            }
        });
    }

}
