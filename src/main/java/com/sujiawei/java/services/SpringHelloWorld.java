package com.sujiawei.java.services;

import com.sujiawei.java.services.impl.HelloWorld;

public class SpringHelloWorld implements HelloWorld {

    @Override
    public void sayHello()  {
        System.out.println("Spring say Hello!");
    }

    @Override
    public void sayHello(String msg) {

    }
}
