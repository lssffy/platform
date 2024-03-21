package com.sp.base.delagate;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:29
 */
public class EmployeeB implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("I am B,I have get " +command +" start");
    }
}
