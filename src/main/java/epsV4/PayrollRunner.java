package epsV4;

import epsV2.EmployeeManager;

/* Main App Class */
public class PayrollRunner {
	public static void main(String[] args) {
		System.out.println("*** Employee Payroll System App - Version 4 ***");

		// jdbc
		JdbcRunner jdbcRunnerObject = new JdbcRunner();
		jdbcRunnerObject.setupJdbc();
	}
}
