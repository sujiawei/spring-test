package com.sujiawei.java.services;

import com.sujiawei.java.bean.User;

public interface UserService {

    User getUser(Integer id);

    void setUser(User user);

    void delUser(Integer id);
}
