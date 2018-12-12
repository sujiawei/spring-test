package com.sujiawei.java.dao;

import com.sujiawei.java.bean.Customer;
import com.sujiawei.java.bean.User;

import java.util.List;

public interface UserDAO {

    void insert(User user);

    void insertWithTemplate(User user);

    Customer findByCustomerId(int custId);

    Customer findByCustomerIdWithTemplate(int custId);

    List<Customer> findAll();

    List<Customer> findAllWithRowMapper();

    String findCustomerNameById(int custId);

    int findTotalCustomer();

    void insertBatch(List<User> users);

    void insertBatchSQL(String sql);
}
