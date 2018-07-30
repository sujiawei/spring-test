package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DepartmentDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/spring-department.xml");
        Department department = (Department) applicationContext.getBean("departmentBean");

        System.out.println(department.toString());
    }
}
