package com.sujiawei.java.testmain;

import com.sujiawei.java.services.HelloWorldService;
import com.sujiawei.java.services.impl.HelloWorld;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorldProgram {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw = service.getHelloWorld();

        hw.sayHello();

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));

        HelloWorldService service1 = (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw1 = service1.getHelloWorld();

        hw1.sayHello();
    }
}
