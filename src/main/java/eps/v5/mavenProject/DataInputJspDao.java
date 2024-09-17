package eps.v5.mavenProject;

import java.sql.*;

public class DataInputJspDao {
	private int idFromEmployeeModel;
	private String nameFromEmployeeModel;
	private int hoursWorkedFromEmployeeModel;
	private double hourlyWageFromEmployeeModel;
	private double salaryFromEmployeeModel;
	private String statusFromEmployeeModel;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/eps_db";
	String username = "root"; // Replace root with your mysql username
	String password = "root"; // Replace root with your mySQl password
	
	public EmployeeModel addEmployee() {
		EmployeeModel modelEmployee = new EmployeeModel();
		
		//retrieve data from index.jsp file via modal class(EmployeeModal)
		idFromEmployeeModel = modelEmployee.getEmployeeId();
		nameFromEmployeeModel = modelEmployee.getEmployeeName();
		hoursWorkedFromEmployeeModel = modelEmployee.getEmployeeHoursWorked();
		hourlyWageFromEmployeeModel = modelEmployee.getEmployeeHourlyWage();
		salaryFromEmployeeModel = modelEmployee.getEmployeeSalary();
		statusFromEmployeeModel = modelEmployee.getEmployeeStatus();
		
		String insertQuery = "INSERT INTO employee(employee_id, name, status, payRate, hours, salary) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setInt(1, idFromEmployeeModel);
			preparedStatement.setString(2, nameFromEmployeeModel);
			preparedStatement.setString(3, statusFromEmployeeModel);
			preparedStatement.setDouble(4, hourlyWageFromEmployeeModel);
			preparedStatement.setInt(5, hoursWorkedFromEmployeeModel);
			preparedStatement.setDouble(6, salaryFromEmployeeModel);
			preparedStatement.executeUpdate();
			
			con.close();
			preparedStatement.close();
		}catch(Exception e) {
			e.setStackTrace(null);
		}
	
		
		return modelEmployee;
	}
}
