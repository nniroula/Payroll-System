package eps.v9_hibernate;

import java.sql.*;

import eps.v6_dao.JdbcCredential;
import eps.v7_jdbcConnector.*;

/* To use Hibernate:
 * 	- instead of insert query, use objects
 * 	- You don't need prepared/callable statements
 *  - set hibernate core and mysql connector in pom.xml file
 *   - Servlet can directly talk to hibernate
 * */

// Each Dao class represents one table in database
public class EmployeeOrmTable {
	private int id;
	private String name;
	private String status;
	private double rate;
	private int hours;
	private double salary;
	
	// object modal to make employee objects
	EmployeeModal employeeModelObject = new EmployeeModal();
	
	// create some objects by using index.jsp user input collected by Servlet
	
	public EmployeeModal addEmployee(int id, String name, String status, double rate, int hours, double salary) {
		employeeModelObject.setEmployeeId(id);
		employeeModelObject.setEmployeeName(name);
		employeeModelObject.setEmployeeStatus(status);
		employeeModelObject.setEmployeeHourlyWage(rate);
		employeeModelObject.setEmployeeHoursWorked(hours);
		employeeModelObject.setEmployeeSalary(salary);

		return employeeModelObject;
	}
	
}
