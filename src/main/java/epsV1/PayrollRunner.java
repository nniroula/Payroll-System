package epsV1;

public class PayrollRunner {
	public static void main(String[] args) {
		System.out.println("****** Employee Payroll System - OOPS Project Version-1 ******");
		System.out.println();
		
		// create a full time employee
		FullTimeEmployee fullTimeEmployeeObject = new FullTimeEmployee("Nabin", 01, 655.00);
		
		// create a part time employee
		PartTimeEmployee partTimeEmployeeObject = new PartTimeEmployee("John Doe", 2, 10, 12.5);
		
		// Employee List
		EmployList employeeList = new EmployList();
		employeeList.addEmployee(fullTimeEmployeeObject);
		employeeList.addEmployee(partTimeEmployeeObject);
		
		// display employee list
		System.out.print(employeeList.displayListOfEmployees());
		System.out.println();
		System.out.println(employeeList.removeEmployee(1));
		System.out.print(employeeList.displayListOfEmployees());
	}
}
