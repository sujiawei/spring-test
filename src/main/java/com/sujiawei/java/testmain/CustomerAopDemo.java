package com.sujiawei.java.testmain;

import com.sujiawei.java.core.CustomerInBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerAopDemo {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("core/spring-customer.xml");
        CustomerInBo customerInBo = (CustomerInBo) applicationContext.getBean("customerInBo");

        customerInBo.addCustomer();
        customerInBo.addCustomerReturnValue();
        //customerInBo.addCustomerThrowException();

        customerInBo.addCustomerAround("sjw");
    }
}
