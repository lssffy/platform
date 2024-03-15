package com.sp.base.abstrfactory;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 15:36
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }
}
