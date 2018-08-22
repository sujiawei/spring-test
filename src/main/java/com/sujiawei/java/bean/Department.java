package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Department implements Serializable {

   private Long deptId;
   private String deptNo;
   private String deptName;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private Person person;

   public Department() {

   }

   public Department(Long deptId, String deptNo, String deptName) {
       this.deptId = deptId;
       this.deptNo = deptNo;
       this.deptName = deptName;
   }

   public Long getDeptId() {
       return deptId;
   }

   public void setDeptId(Long deptId) {
       this.deptId = deptId;
   }

   public String getDeptNo() {
       return deptNo;
   }

   public void setDeptNo(String deptNo) {
       this.deptNo = deptNo;
   }

   public String getDeptName() {
       return deptName;
   }

   public void setDeptName(String deptName) {
       this.deptName = deptName;
   }

   public String toString() {
       return JSON.toJSONString(this);
   }
}