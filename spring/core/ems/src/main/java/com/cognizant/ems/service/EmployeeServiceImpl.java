package com.cognizant.ems.service;

import java.util.List;

import com.cognizant.ems.dao.EmployeeDao;
import com.cognizant.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		
		boolean addStatus = employeeDao.addEmployee(employee);
		if(addStatus) {
			System.out.println("Employee added successfully");
		} else {
			System.out.println("Employee with Employee ID: "+employee.getEmployeeId()+"already exists.");
		}
	}
	
	@Override
	public void listEmployees() {
		List<Employee> employeeList = employeeDao.listEmployee();
		employeeList.stream().forEach(System.out::println);
		
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		
		boolean updEmp=employeeDao.updateEmployee(employee);
		if(updEmp) {
			System.out.println("Employee update successfully");
		} else {
			System.out.println("Employee with Employee ID: "+employee.getEmployeeId()+"Update successfuly");
		}
	}
	
	
	
	@Override
	public void deleteEmployee(Employee employee) {
		boolean delEmp=employeeDao.deleteEmployee(employee);
		if(delEmp) {
			System.out.println("Employee deleted successfully");
		} else {
			System.out.println("Employee with Employee ID: "+employee.getEmployeeId()+" Deleted successfuly");
		}		
	}
	

}
