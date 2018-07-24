package com.sujiawei.java.services;

import com.sujiawei.java.services.impl.HelloWorld;

// And Service class
public class HelloWorldService {
     // Field type HelloWorld
     private HelloWorld helloWorld;

     public HelloWorldService(HelloWorld helloWorld) {
          this.helloWorld = helloWorld;
     }
    
     // Constructor HelloWorldService
     // It initializes the values for the field 'helloWorld'
     public HelloWorldService()  {
           this.helloWorld = new StrutsHelloWorld();
     }

     public HelloWorld getHelloWorld() {
          return helloWorld;
     }

     //Ioc container
     public void setHelloWorld(HelloWorld helloWorld) {
          this.helloWorld = helloWorld;
     }


}