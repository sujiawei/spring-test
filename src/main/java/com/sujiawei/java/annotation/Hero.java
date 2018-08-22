package com.sujiawei.java.annotation;

public class Hero {

    @Deprecated
    public void say() {
        System.out.println("Nothing has to say!");
    }

    public void speak() {
        System.out.println("I have a dream!");
    }
}
