package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Worker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WorkerDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/spring-worker.xml");

        Worker worker = (Worker) applicationContext.getBean("worker");

        worker.getPerson().say();
    }
}
