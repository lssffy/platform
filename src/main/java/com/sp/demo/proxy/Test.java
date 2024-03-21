package com.sp.demo.proxy;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/8 10:33
 */
public class Test {

    public static void main(String[] args) {
        try {
            OneDay oneDay1 = (OneDay) new InvocationHandlerJDK().getInstance(new LaoWang());
            oneDay1.play();
            oneDay1.eat();
            oneDay1.sleep();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
