package com.sp.base.simple;


import com.sp.base.factory.ICourseFactory;
import com.sp.base.factory.JavaFactory;
import com.sp.base.factory.PythonFactory;

/**
 * @author : lssffy
 * @Description : 测试
 * @date : 2024/3/13 14:57
 */
public class Test {
    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        System.out.println(course.record());
        ICourse course1 = new PythonCourse();
        System.out.println(course1.record());

        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getInstance("com.sp.base.simple.JavaCourse").record());

        System.out.println(simpleFactory.createInstance(PythonCourse.class).record());

        ICourseFactory javaFactory = new JavaFactory();
        System.out.println(javaFactory.record().record());

        ICourseFactory pythonFactory = new PythonFactory();
        System.out.println(pythonFactory.record().record());
    }
}
