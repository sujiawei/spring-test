package com.sujiawei.java.testmain;

import com.sujiawei.java.action.UserAction;
import com.sujiawei.java.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User2Demo {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/spring-aop-test.xml");
        UserAction userAction = (UserAction) applicationContext.getBean("userAction");
        User user = new User();
        user.setId(111);
        user.setName("sjw");
        userAction.setUser(user);
    }
}
