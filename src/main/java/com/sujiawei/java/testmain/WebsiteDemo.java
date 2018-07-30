package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Website;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebsiteDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/spring-website.xml");
        //Website website = (Website) applicationContext.getBean("websiteServiceProxy");
        Website website = (Website) applicationContext.getBean("website");
        System.out.println("*************************");
        website.printName();
        System.out.println("*************************");
        website.printUrl();
        System.out.println("*************************");
        try {
            website.printThrowException();
        } catch (Exception e) {

        }
    }
}
