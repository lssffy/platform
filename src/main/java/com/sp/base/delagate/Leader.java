package com.sp.base.delagate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:31
 */
public class Leader implements IEmployee{

    private Map<String,IEmployee> map = new HashMap<String,IEmployee>();

    public Leader() {
        map.put("加密",new EmployeeA());
        map.put("登录",new EmployeeB());
    }

    @Override
    public void doing(String command) {
        map.get(command).doing(command);
    }
}
