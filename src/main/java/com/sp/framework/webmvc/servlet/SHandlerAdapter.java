package com.sp.framework.webmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/1 22:08
 */
public class SHandlerAdapter {

    public boolean supports(Object handler){return handler instanceof SHandlerMapping;}

    public SModelAndView handler(HttpServletRequest request, HttpServletResponse response, Object handler){
        return null;
    }
}
