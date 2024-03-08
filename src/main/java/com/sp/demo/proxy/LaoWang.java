package com.sp.demo.proxy;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/8 10:26
 */
public class LaoWang implements OneDay{
    @Override
    public void eat() {
        System.out.println("准备碗筷");
        System.out.println("开始吃饭");
        System.out.println("收拾碗筷");
    }

    @Override
    public void play() {
        System.out.println("打开电脑");
        System.out.println("登录账号");
        System.out.println("开始玩");
    }

    @Override
    public void sleep() {
        System.out.println("开始洗澡");
        System.out.println("躺倒床上");
        System.out.println("开始睡觉");
    }
}
