package com.sp.demo.abstr;

import com.sp.demo.dto.Person;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 17:16
 */
public class printArray {

    public static <E> void printArray(E[] array){
        for(E e:array){
            System.out.printf("%s",e);
        }
    }

    public static void main(String[] args) {
        printArray.printArray(new Object[2]);
        System.out.println("\n");
        Box<Person> personBox = new Box<Person>();
        personBox.add(new Person("John", "John",23));
        Person person = personBox.getT();
        System.out.println(person);
    }
}


