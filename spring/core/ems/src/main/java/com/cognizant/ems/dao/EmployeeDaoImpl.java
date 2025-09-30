package com.cognizant.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public boolean addEmployee(Employee employee) {
		
		for(Employee e : employeeList) {
			if(employee.getEmployeeId().equals(e.getEmployeeId())) {
				return false;
			}
		}
		employeeList.add(employee);
		return true;
	}
	@Override
	public List<Employee> listEmployee() {
		
		return employeeList;
	}
	
	@Override
	public boolean updateEmployee(Employee employee) {
		for(int i = 0 ; i < employeeList.size() ; i++) {
			if(employeeList.get(i).getEmployeeId().equals(employee.getEmployeeId())) {
				employeeList.set(i, employee);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean deleteEmployee(Employee employee) {
		for(int i = 0 ; i < employeeList.size(); i++) {
			if(employeeList.get(i).getEmployeeId().equals(employee.getEmployeeId())) {
				employeeList.remove(i);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean findEmployee(Employee employee) {
		for(int i = 0 ; i < employeeList.size();i++) {
			if(employeeList.get(i).getEmployeeName().contains(employee.getEmployeeName())) {
				employeeList.se
			}
		}
		return false;
	}

}
