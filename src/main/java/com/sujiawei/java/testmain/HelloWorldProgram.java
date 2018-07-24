package com.sujiawei.java.testmain;

import com.sujiawei.java.services.HelloWorldService;
import com.sujiawei.java.services.impl.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldProgram {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw = service.getHelloWorld();

        hw.sayHello();
    }
}
