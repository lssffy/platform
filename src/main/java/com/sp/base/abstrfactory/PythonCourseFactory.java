package com.sp.base.abstrfactory;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 15:37
 */
public class PythonCourseFactory implements CourseFactory{
    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }

    @Override
    public INote createNote() {
        return new PythonNote();
    }
}
