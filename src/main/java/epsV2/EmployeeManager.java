package epsV2;

/* Main App Class */
public class EmployeeManager {
	public static void manageEmployee() {
		// Employee List
		EmployList employeeList = new EmployList();
		System.out.print(employeeList.displayListOfEmployees()); // display employee list
		System.out.println();
		
		/*Part time employee Data I/O */
		PartTimeEmployeeDataIO partTimeEmployeeDataIO = new PartTimeEmployeeDataIO();
		Employee newPartTimeAssociate = partTimeEmployeeDataIO.createPartTimeEmployee(); //create a part time employee
		employeeList.addEmployee(newPartTimeAssociate);	
		
		String partTimeAssociateSalary = newPartTimeAssociate.displaySalary();
		System.out.println("Gross Pay: " + partTimeAssociateSalary);
		System.out.println();
		
		/* Full time employee */
		FullTimeEmployeeDataIO fullTimeEmployeeDataIO = new FullTimeEmployeeDataIO();
		Employee newFullTimeAssociate = fullTimeEmployeeDataIO.createFullTimeEmployee(); //create a full time employee
		employeeList.addEmployee(newFullTimeAssociate);
		
		String fullTimeAssociateSalary = newFullTimeAssociate.displaySalary();
		System.out.println("Salary: " + fullTimeAssociateSalary);
		
		/* display employee list */
		System.out.println();
		System.out.println("Employee list: ");
		System.out.println(employeeList.displayListOfEmployees());
	}
}
