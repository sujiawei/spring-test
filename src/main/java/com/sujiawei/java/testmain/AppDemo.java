package com.sujiawei.java.testmain;

import com.sujiawei.java.config.AppConfig;
import com.sujiawei.java.core.CustomerBo;
import com.sujiawei.java.core.SchedulerBo;
import com.sujiawei.java.services.impl.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloBean");
        helloWorld.sayHello("java config");

        CustomerBo customerBo = (CustomerBo) ac.getBean("customer");
        customerBo.printMsg("Hello customerBo");

        SchedulerBo scheduler = (SchedulerBo) ac.getBean("scheduler");
        scheduler.printMsg("Hello schedulerBo");
    }
}
