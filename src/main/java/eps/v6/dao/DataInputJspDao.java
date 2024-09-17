package eps.v6.dao;

import java.sql.*;

// Each Dao class represents one table in database
public class DataInputJspDao {
	
	String mysqlJdbcUrl;
	String mysqlUsername;
	String mysqlPassword;
	
	EmployeeModel employeeModelObject = new EmployeeModel();
	
	public EmployeeModel addEmployee(int id, String name, String status, double rate, int hours, double salary) {
		// Jdbc credential class
		JdbcCredential jdbcCredential = new JdbcCredential();
		mysqlJdbcUrl = jdbcCredential.getJdbcUrl();;
		mysqlUsername = jdbcCredential.getUsername();
		mysqlPassword = jdbcCredential.getPassword();

		String insertQuery = "INSERT INTO employee(employee_id, name, status, payRate, hours, salary) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(mysqlJdbcUrl, mysqlUsername, mysqlPassword);
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, status);
			preparedStatement.setDouble(4, rate);
			preparedStatement.setInt(5, hours);
			preparedStatement.setDouble(6, salary);
			preparedStatement.executeUpdate();
			
			con.close();
			preparedStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// set values to employee model class
		employeeModelObject.setEmployeeId(id);
		employeeModelObject.setEmployeeName(name);
		employeeModelObject.setEmployeeStatus(status);
		employeeModelObject.setEmployeeHourlyWage(hours);
		employeeModelObject.setEmployeeHoursWorked(hours);
		employeeModelObject.setEmployeeSalary(salary);
		
		return employeeModelObject;
	}
}
