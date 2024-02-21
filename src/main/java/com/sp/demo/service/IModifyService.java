package com.sp.demo.service;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/28 16:36
 */
public interface IModifyService {
    /**
     * 增加
     */
    public String add(String name, String addr);

    /**
     * 修改
     */
    public String edit(Integer id, String name);

    /**
     * 删除
     */
    public String remove(Integer id);
}
