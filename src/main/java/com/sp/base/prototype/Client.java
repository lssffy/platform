package com.sp.base.prototype;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 11:40
 */
public class Client {

    private ProtoType protoType;

    public Client(ProtoType protoType) {
        this.protoType = protoType;
    }

    public ProtoType startClone(ProtoType concreteType) {
        return concreteType.clone();
    }
}
