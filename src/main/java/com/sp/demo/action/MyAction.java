package com.sp.demo.action;

import com.sp.demo.service.IModifyService;
import com.sp.demo.service.IQueryService;
import com.sp.framework.annotation.SAutowired;
import com.sp.framework.annotation.SController;
import com.sp.framework.annotation.SRequestMapping;
import com.sp.framework.annotation.SRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/28 16:36
 */
@SController
@SRequestMapping("/web")
public class MyAction {

    @SAutowired IQueryService iQueryService;

    @SAutowired IModifyService iModifyService;

    @SRequestMapping("/query.json")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @SRequestParam("name")String name){
        String result = iQueryService.query(name);
        out(response, result);
    }

    @SRequestMapping("/add.json")
    public void add(HttpServletRequest request, HttpServletResponse response,
                    @SRequestParam("name") String name,@SRequestParam("addr") String addr){
        String result = iModifyService.add(name, addr);
        out(response, result);
    }

    @SRequestMapping("/remove.json")
    public void remove(HttpServletRequest request, HttpServletResponse response,
                       @SRequestParam("id") Integer id){
        String result = iModifyService.remove(id);
        out(response, result);
    }

    @SRequestMapping("/edit.json")
    public void edit(HttpServletRequest request,HttpServletResponse response,
                     @SRequestParam("id") Integer id,@SRequestParam("name") String name){
        String result = iModifyService.edit(id, name);
        out(response, result);
    }

    private void out(HttpServletResponse response, String result) {
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
