package com.sp.base.delagate;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:35
 */
public class Test {
    public static void main(String[] args) {
        new Boss().command("加密",new Leader());
        new Boss().command("登录",new Leader());
    }
}
