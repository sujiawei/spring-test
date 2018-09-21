package com.sujiawei.java.services.impl;

import com.sujiawei.java.annotation.CheckEmpty;
import com.sujiawei.java.annotation.TxManagerAnnotation;
import com.sujiawei.java.bean.User;
import com.sujiawei.java.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> userMap = new HashMap<>();

    @Override
    public User getUser(Integer id) {

        System.out.println("useService: getUser: " + id);
        return null;
    }

    @Override
    @TxManagerAnnotation
    public void setUser(@CheckEmpty(fields = "id") User user) {

        System.out.println("useService: setUser: " + user.toString());
    }

    @Override
    @TxManagerAnnotation
    public void delUser(Integer id) {

        System.out.println("useService: delUser: " + id);
    }
}
