package com.sujiawei.java.dao;

import java.util.List;

import com.sujiawei.java.bean.Department;

public interface DepartmentDAO {
   
   public List<Department> queryDepartment() throws Exception ;

}