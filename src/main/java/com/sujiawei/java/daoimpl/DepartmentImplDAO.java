package com.sujiawei.java.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sujiawei.java.bean.Department;
import com.sujiawei.java.dao.DepartmentDAO;

public class DepartmentImplDAO implements DepartmentDAO {

   private DataSource dataSource;

   public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
   }

   @Override
   public List<Department> queryDepartment() throws SQLException {
       Connection conn = dataSource.getConnection();

       String sql = "Select d.dept_id, d.dept_no, d.dept_name from department d";
       Statement smt = conn.createStatement();

       ResultSet rs = smt.executeQuery(sql);
       List<Department> list = new ArrayList<Department>();
       while (rs.next()) {
           Long deptId = rs.getLong("dept_id");
           String deptNo = rs.getString("dept_no");
           String deptName = rs.getString("dept_name");
           Department dept = new Department(deptId, deptNo, deptName);
           list.add(dept);
       }
       return list;
   }

}