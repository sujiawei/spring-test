package com.sujiawei.java.testmain;

import com.sujiawei.java.bean.Customer;
import com.sujiawei.java.dao.CustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class CustomerDemo
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("spring-module.xml");
    	 
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        //Customer customer = new Customer(4, "sujiawei",28);
        //customerDAO.insertWithTemplate(customer);
    	
        Customer customer1 = customerDAO.findByCustomerId(4);
        System.out.println(customer1.toString());

        Customer customer2 = customerDAO.findByCustomerIdWithTemplate(4);
        System.out.println(customer2.toString());

        List<Customer> customerList = customerDAO.findAll();
        System.out.println(customerList);

        List<Customer> customerList1 = customerDAO.findAllWithRowMapper();
        System.out.println(customerList1);

        String name = customerDAO.findCustomerNameById(4);
        System.out.println(name);

        int total = customerDAO.findTotalCustomer();
        System.out.println(total);


        String sql = "UPDATE CUSTOMER SET NAME ='BATCHUPDATE'";
        customerDAO.insertBatchSQL(sql);

        Customer customer3 = new Customer(5, "sujiawe5",21);
        Customer customer4 = new Customer(6, "sujiawe6",22);
        Customer customer5 = new Customer(7, "sujiawe7",23);

        List<Customer>customers = new ArrayList<Customer>();
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        customerDAO.insertBatch(customers);
    }
}