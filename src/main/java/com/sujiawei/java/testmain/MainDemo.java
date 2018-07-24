package com.sujiawei.java.testmain;

import java.util.List;

import com.sujiawei.java.bean.Department;
import com.sujiawei.java.dao.DepartmentDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {

   public static void main(String[] args) throws Exception {
       ApplicationContext context = new ClassPathXmlApplicationContext(
               "spring-module.xml");

       DepartmentDAO deptDAO = (DepartmentDAO) context
               .getBean("departmentDAO");

       List<Department> depts = deptDAO.queryDepartment();

       for (Department dept : depts) {
           System.out.println("Dept ID " + dept.getDeptId());
           System.out.println("Dept No " + dept.getDeptNo());
           System.out.println("Dept Name " + dept.getDeptName());
       }
   }

}