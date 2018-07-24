package com.sujiawei.java.services;

import com.sujiawei.java.services.impl.HelloWorld;

// Other class implements HelloWorld
public class StrutsHelloWorld implements HelloWorld {

    @Override
    public void sayHello()  {
           System.out.println("Struts say Hello!");
   }
}