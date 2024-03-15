package com.sp.base.factory;

import com.sp.base.simple.ICourse;
import com.sp.base.simple.PythonCourse;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 15:26
 */
public class PythonFactory implements ICourseFactory{
    @Override
    public ICourse record() {
        return new PythonCourse();
    }
}
