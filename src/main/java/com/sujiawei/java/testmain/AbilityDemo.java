package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Ability;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbilityDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/spring-ability.xml");
        Ability ability = (Ability) applicationContext.getBean("AbilityBean");
        System.out.println(ability.toString());
    }
}
