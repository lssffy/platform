package com.sp.base.factory;

import com.sp.base.simple.ICourse;
import com.sp.base.simple.JavaCourse;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 15:24
 */
public class JavaFactory implements ICourseFactory{
    @Override
    public ICourse record() {
        return new JavaCourse();
    }
}
