package com.cognizant.ems.dao;

import java.util.List;

import com.cognizant.ems.model.Employee;

public interface EmployeeDao {
   public boolean addEmployee(Employee employee);
   public List<Employee> listEmployee();
   public boolean updateEmployee(Employee employee);
   public boolean deleteEmployee(Employee employee);
   public boolean findEmployee(Employee employee);
}
