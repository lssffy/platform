package com.sp.demo.service.impl;

import com.sp.demo.service.IQueryService;
import com.sp.framework.annotation.SService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/28 16:39
 */
@SService
public class QueryServiceImpl implements IQueryService {
    @Override
    public String query(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String json = "{name:\"" + name + "\",time:\""+time + "\"}";
        return json;
    }
}
