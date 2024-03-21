package com.sp.base.delagate;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:35
 */
public class Boss {
    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
