package com.cognizant.spring.core.bean;

import java.util.List;

public class Hospital {
   private String hospitalName;
   private List<String> deptName;
   
   
   public String getHospitalName() {
	return hospitalName;
   }
   public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
   }
   public List<String> getDeptName() {
	return deptName;
   }
   public void setDeptName(List<String> deptName) {
	this.deptName = deptName;
   }
   
   
}
