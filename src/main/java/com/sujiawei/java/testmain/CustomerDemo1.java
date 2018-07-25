package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDemo1 {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"bean/spring-customer.xml"});

        Customer cust = (Customer)context.getBean("CustomerBean");
        System.out.println(cust);
    }
}
