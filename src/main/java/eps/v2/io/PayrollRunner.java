package eps.v2.io;

/* Main App Class */
public class PayrollRunner {
	public static void main(String[] args) {
		System.out.println("****** Employee Payroll System App - Version 2 ******");

		// EmployeeManager employeeManager = new EmployeeManager();
		// employeeManager.manageEmployee();
		/* Access static method on a static way (invoke it on a class) */
		EmployeeManager.manageEmployee();
		
	}
}
