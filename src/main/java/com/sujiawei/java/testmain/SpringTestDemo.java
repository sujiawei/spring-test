package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Customer;
import com.sujiawei.java.spring.bean.impl.AbstractApplicationContext;

public class SpringTestDemo {

    public static void main(String[] args) {
        AbstractApplicationContext ac = new AbstractApplicationContext();
        ac.setUpElements(new String[] {"bean/spring-department.xml"});
        //Department department = (Department) ac.getBean("departmentBean");
        //System.out.println(department.toString());

        Customer customer = (Customer) ac.getBean("customerBean");
        System.out.println(customer.toString());
    }
}
