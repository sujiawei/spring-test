package com.sujiawei.java.testmain;

import com.sujiawei.java.services.impl.OutputHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/spring-output.xml");
        OutputHelper outputHelper = (OutputHelper) applicationContext.getBean("OutputHelper");
        outputHelper.generateOutput();
    }
}
