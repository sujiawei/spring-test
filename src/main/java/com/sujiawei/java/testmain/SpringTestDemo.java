package com.sujiawei.java.testmain;

import com.sujiawei.java.spring.bean.impl.AbstractApplicationContext;

public class SpringTestDemo {

    public static void main(String[] args) {
        AbstractApplicationContext ac = new AbstractApplicationContext();
        ac.setUpElements(new String[] {"bean/spring-department.xml"});
//        "spring-department.xml"
//        "departmentBean"
        ac.getBean("departmentBean");
    }
}
