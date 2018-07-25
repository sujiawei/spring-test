package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean/spring-person.xml");
        Person person = (Person) ac.getBean("PersonBean");

        System.out.println(person.toString());
        System.out.println(person.getAbility().toString());
    }
}
