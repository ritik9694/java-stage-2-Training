package com.cognizant.ems;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.service.EmployeeService;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ems-beans.xml");

		EmployeeService employeeService = (EmployeeService) context.getBean("emp-service");

		while (true) {
			System.out.println("1. Add Employee");
			System.out.println("2. List Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("Enter your Option: ");

			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("enter employee id: ");
				int eid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter employee name: ");
				String name = sc.nextLine();
				employeeService.saveEmployee(new Employee(eid, name));
				break;

			case 2:
				employeeService.listEmployees();
				break;

			case 3:
				System.out.println("Enter employee id to update: ");
				int updateId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new employee name: ");
				String newName = sc.nextLine();
				employeeService.updateEmployee(new Employee(updateId, newName));
				;

				break;

			case 4:

				System.out.println("Enter employee id to delete: ");
				int deleteId = sc.nextInt();
				sc.nextLine();
				Employee empToDelete = new Employee(deleteId, null); // name not needed
				employeeService.deleteEmployee(empToDelete);
				break;

			case 5:
				System.out.println("Application designed and developed by CTS");
				System.exit(0);
			default:
				System.err.println("Invalid option ....Try again");
			}
		}
	}

}
