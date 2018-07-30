package com.sujiawei.java.testmain;

import com.sujiawei.java.common.MailMail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendMailDemo {

    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("core/spring-mail.xml");

        MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("sujiawei1@163.com",
                "sujiawei@yongche.com",
                "同一个人",
                "我是163邮箱only \n\n Hello Spring Email Sender");

    }
}
