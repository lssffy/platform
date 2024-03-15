package com.sp.base.abstrfactory;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/13 15:38
 */
public class Test {
    public static void main(String[] args) {
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createVideo().record();
        javaCourseFactory.createNote().edit();
    }
}
