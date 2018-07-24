package com.sujiawei.java.daoimpl;

import com.sujiawei.java.bean.Customer;
import com.sujiawei.java.dao.CustomerDAO;
import com.sujiawei.java.model.CustomerRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerImplDAO extends JdbcDaoSupport implements CustomerDAO {

    @Override
    public void insert(Customer customer) {
        String sql = "insert into customer (cust_id, name, age) values (?, ?, ?) ";

        Connection connection = null;

        try {
            connection = getJdbcTemplate().getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public void insertWithTemplate(Customer customer) {

        String sql = "insert into customer (cust_id, name, age) values (?, ?, ?) ";


        getJdbcTemplate().update(sql, customer.getCustId(), customer.getName(), customer.getAge());
    }

    @Override
    public Customer findByCustomerIdWithTemplate(int custId) {

        String sql = "select * from customer where cust_id = ?";

        //Customer customer = getJdbcTemplate().queryForObject(sql, BeanPropertyRowMapper.newInstance(Customer.class), custId);
        Customer customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] {custId}, new CustomerRowMapper());

        return customer;
    }

    @Override
    public Customer findByCustomerId(int custId) {
        String sql = "select * from customer where cust_id = ?";

        Connection connection = null;

        try {
            connection = getJdbcTemplate().getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getInt("cust_id"), rs.getString("name"), rs.getInt("age"));
            }
            rs.close();
            ps.close();
            return customer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public List<Customer> findAll(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers = new ArrayList<Customer>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Customer customer = new Customer();
            customer.setCustId(((Long)row.get("CUST_ID")).intValue());
            customer.setName((String)row.get("NAME"));
            customer.setAge(((Long)row.get("AGE")).intValue());
            customers.add(customer);
        }

        return customers;
    }


    @Override
    public List<Customer> findAllWithRowMapper(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Customer.class));
        return customers;
    }

    @Override
    public String findCustomerNameById(int custId){

        String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";

        String name = (String)getJdbcTemplate().queryForObject(sql, new Object[] { custId }, String.class);

        return name;

    }

    @Override
    public int findTotalCustomer(){

        String sql = "SELECT COUNT(*) FROM CUSTOMER";

        int total = getJdbcTemplate().queryForObject(sql, Integer.class);

        return total;
    }


}
