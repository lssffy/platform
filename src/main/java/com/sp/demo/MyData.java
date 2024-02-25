package com.sp.demo;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/22 9:23
 */
public class MyData {

    private int j = 0;

    public synchronized void add(){
        j++;
        System.out.println("线程a:" + Thread.currentThread().getName() + "j为" + j);
    }
    public synchronized void desc(){
        j--;
        System.out.println("线程d:" + Thread.currentThread().getName() + "j为" + j);
    }

    public int getData() {
        return j;
    }

    public static void main(String[] args) {
        MyData myData = new MyData();
        Runnable runnable = new AddRunnable(myData);
        Runnable runnable1 = new DescRunnable(myData);
        for (int i = 0; i < 2; i++) {
            runnable.run();
            runnable1.run();
            new Thread(runnable).start();
            new Thread(runnable1).start();
        }
    }
}

class AddRunnable implements Runnable{

    MyData myData;

    public AddRunnable(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.add();
    }
}

class DescRunnable implements Runnable{

    MyData myData;

    public DescRunnable(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.desc();
    }
}
