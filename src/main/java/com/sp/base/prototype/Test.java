package com.sp.base.prototype;

import java.util.Arrays;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 11:43
 */
public class Test {
    public static void main(String[] args) {
        ConcreteProtoTypeA concreteProtoTypeA = new ConcreteProtoTypeA();
        concreteProtoTypeA.setAge(16);
        concreteProtoTypeA.setName("joyous");
        concreteProtoTypeA.setHobbies(Arrays.asList(1,2,3,4,5));
        System.out.println(concreteProtoTypeA);

//        Client client = new Client(concreteProtoTypeA);
//        ConcreteProtoTypeA concreteProtoTypeA1 = (ConcreteProtoTypeA) client.startClone(concreteProtoTypeA);
        ConcreteProtoTypeA concreteProtoTypeA1 = (ConcreteProtoTypeA) concreteProtoTypeA.deepCopy();
        System.out.println(concreteProtoTypeA1);


    }
}
