package com.sp.base.prototype;

import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 11:37
 */
@Data
public class ConcreteProtoTypeA implements Cloneable, Serializable {

    private int age;

    private String name;

    private List hobbies;



    public Object deepCopy() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            ConcreteProtoTypeA copy = (ConcreteProtoTypeA) ois.readObject();
            copy.age = 18;
            return copy;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object clone(){
       return this.deepCopy();
    }

//    @Override
//    public ProtoType clone() {
//        ConcreteProtoTypeA concreteProtoTypeA = new ConcreteProtoTypeA();
//        concreteProtoTypeA.setAge(age);
//        concreteProtoTypeA.setName(name);
//        concreteProtoTypeA.setHobbies(hobbies);
//        return concreteProtoTypeA;
//    }
}
