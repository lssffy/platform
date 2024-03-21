package com.sp.base.delagate;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:28
 */
public class EmployeeA implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("I am A,I have get " +command +" start");
    }
}
