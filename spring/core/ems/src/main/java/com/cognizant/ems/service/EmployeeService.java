package com.cognizant.ems.service;

import com.cognizant.ems.model.Employee;

public interface EmployeeService {
   public void saveEmployee(Employee employee);
   public void listEmployees();
   public void updateEmployee(Employee employee);
   public void deleteEmployee(Employee employee);
}
