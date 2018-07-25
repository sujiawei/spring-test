package com.sujiawei.java.testmain;

import com.sujiawei.java.services.impl.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceDemo {

    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"service/spring-customer.xml"});

        CustomerService custA = (CustomerService)context.getBean("customerService");
        custA.setMessage("Message by custA");
        System.out.println("Message : " + custA.getMessage());

        //retrieve it again
        CustomerService custB = (CustomerService)context.getBean("customerService");
        System.out.println("Message : " + custB.getMessage());
    }
}
