package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/spring-book.xml");
        Book book = (Book) applicationContext.getBean("bookBean");
        System.out.println(book.toString());
    }
}
