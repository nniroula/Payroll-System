package eps.v3.jdbcStatic;

import eps.v2.io.EmployeeManager;

/* Main App Class */
public class PayrollRunner {
	public static void main(String[] args) {
		System.out.println("*** Employee Payroll System App - Version 3 ***");
		//EmployeeManager.manageEmployee();
		
		// jdbc
		JdbcRunner jdbcRunnerObject = new JdbcRunner();
		jdbcRunnerObject.setupJdbc();
	}
}
