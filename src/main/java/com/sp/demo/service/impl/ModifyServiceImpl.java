package com.sp.demo.service.impl;

import com.sp.demo.service.IModifyService;
import com.sp.framework.annotation.SService;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/28 16:37
 */
@SService
public class ModifyServiceImpl implements IModifyService {
    @Override
    public String add(String name, String addr) {
        return "IModifyService add name=" + name + ",addr=" + addr;
    }

    @Override
    public String edit(Integer id, String name) {
        return "IModifyService edit name=" + name + ",id=" + id;
    }

    @Override
    public String remove(Integer id) {
        return "IModifyService remove id=" + id;
    }
}
