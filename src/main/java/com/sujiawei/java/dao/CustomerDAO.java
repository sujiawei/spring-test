package com.sujiawei.java.dao;

import com.sujiawei.java.bean.Customer;

import java.util.List;

public interface CustomerDAO {

    void insert(Customer customer);

    void insertWithTemplate(Customer customer);

    Customer findByCustomerId(int custId);

    Customer findByCustomerIdWithTemplate(int custId);

    List<Customer> findAll();

    List<Customer> findAllWithRowMapper();

    String findCustomerNameById(int custId);

    int findTotalCustomer();
}
