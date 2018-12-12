package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.User;
import com.sujiawei.java.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDBDemo
{
    public static void main( String[] args )
    {
    	ApplicationContext context =
    		new ClassPathXmlApplicationContext("spring-module.xml");
    	 
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        //Customer customer = new Customer(4, "sujiawei",28);
        //customerDAO.insertWithTemplate(customer);

        List<User> users = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            User user = new User();
            user.setId(i);
            user.setName(getRandomString(getRandom(string.length())));
            user.setBirthday(getRandomBirthday());
            users.add(user);
        }

        userDAO.insertBatch(users);

        String sql = "UPDATE CUSTOMER SET NAME ='BATCHUPDATE'";
        //customerDAO.insertBatchSQL(sql);
    }

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    private static String string = "abcdefghijklmnopqrstuvwxyz";

    private static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }

    private static Integer getRandomBirthday() {
        int time = getRandom((int)(System.currentTimeMillis()/1000));
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        long lt = new Long(time*1000L);
        Date date = new Date(lt);
        return Integer.valueOf(format.format(date));

    }
}