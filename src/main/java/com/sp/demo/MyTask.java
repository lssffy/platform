package com.sp.demo;

import java.util.concurrent.Callable;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/28 23:12
 */
public class MyTask implements Callable<Integer> {
    private int upperCount;

    public MyTask(int upperCount) {
        this.upperCount = upperCount;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < upperCount; i++){
            sum += i;
        }
        return sum;
    }
}
