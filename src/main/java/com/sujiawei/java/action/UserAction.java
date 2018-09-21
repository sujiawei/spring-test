package com.sujiawei.java.action;

import com.sujiawei.java.bean.User;
import com.sujiawei.java.services.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserAction {

    @Resource
    private UserService userService;

    public User getUser(Integer id) {
        System.out.println("userAction : getUser :");
        return userService.getUser(id);
    }

    public void setUser(User user) {

        userService.setUser(user);
        System.out.println("userAction : setUser :");
    }

    public void delUser(Integer id) {

        userService.delUser(id);
        System.out.println("userAction : delUser :");
    }
}
