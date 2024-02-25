package com.sp.demo.abstr;

public class Box<T> {
    private T t;
    public void add(T t) { this.t = t;}

    public T getT() {
        return t;
    }
}
