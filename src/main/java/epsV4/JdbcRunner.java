package epsV4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcRunner {
	public void setupJdbc() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/eps_db";
		String username = "root"; // Replace root with your mysql username
		String password = "root"; // Replace root with your mySQl password
		
		EmployeeDataIO employeeDataIo = new EmployeeDataIO();
		employeeDataIo.getUserInputData();
		
		// ----- user input values. Get from console or GUI -------
		int idFromConsole = employeeDataIo.getEmployeeId();
		String nameFromConsole = employeeDataIo.getEmployeeName();
		String statusFromConsole = employeeDataIo.getEmployeeStatus();
		double hourlyWageFromConsole = employeeDataIo.getEmployeeHourlyWage();
		int hoursWorkedFromConsole = employeeDataIo.getEmployeeHoursWorked();
		double salaryFromConsole = employeeDataIo.getEmployeeSalary();
		int inputIdForUpdate = idFromConsole;
		int inputIdForDynamicSelect = idFromConsole;
		

		/* 1. INSERT queries -> executeUpdate() */
		String insertQueryThree = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)"; //dynamic approach
		
		
		/* 2.  SELECT queries */
		String selectQuery = "SELECT * FROM employee";
		//Dynamic way
		String selectQueryDynamic = "SELECT * FROM employee WHERE employee_id = ?";
		
		
		/* 3. DELETE queries */
		//Dynamic approach
		// int userSelectedId = 2; // store user input in this
		// String deleteQueryDyanmic = "DELETE FROM employee WHERE employee_id = ?"; // provide value for ? in prepared statement
		
		
		/* 4. UPDATE queries */
		//update query in dynamic way
		//String updateQueryDynamic = "UPDATE employee SET employee_id = 500, name = 'Beauty of Programming', status='Underway', payRate = '30.00' WHERE employee_id = ?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			
			PreparedStatement preparedStatementInsertThree = con.prepareStatement(insertQueryThree);
			
			/* 1. INSERT queries -> executeUpdate() */
			// with positional parameters - Dynamic way
			preparedStatementInsertThree.setInt(1, idFromConsole);
			preparedStatementInsertThree.setString(2, nameFromConsole);
			preparedStatementInsertThree.setString(3, statusFromConsole);
			preparedStatementInsertThree.setDouble(4, hourlyWageFromConsole);
			preparedStatementInsertThree.setInt(5, hoursWorkedFromConsole);
			preparedStatementInsertThree.setDouble(6, salaryFromConsole);
			preparedStatementInsertThree.executeUpdate(); // you do not have to pass in insertQueryThree as it is already passed in above
				
			/*2.  SELECT queries */
			// SELECT Dynamic
			PreparedStatement preparedStatementSelectDynamic = con.prepareStatement(selectQueryDynamic);
			preparedStatementSelectDynamic.setInt(1, inputIdForDynamicSelect);
			ResultSet resultSetDynamicSelect = preparedStatementSelectDynamic.executeQuery();
			System.out.println();
			System.out.println("Dynamic select with positional argument....");
			int empId;
			String empName;
			String empStatus;
			while(resultSetDynamicSelect.next()) {
				empId = resultSetDynamicSelect.getInt("employee_id");
				empName = resultSetDynamicSelect.getString("name");
				empStatus = resultSetDynamicSelect.getString("status");
				System.out.printf("employee id = %d, name = %s, status = %s", empId, empName, empStatus);
				System.out.println();
			}
			
			
			/* 3. DELETE queries */
			// Dynamic delete approach
			//PreparedStatement preparedStatementDeleteDynamic = con.prepareStatement(deleteQueryDyanmic);
			//preparedStatementDeleteDynamic.setInt(1, userSelectedId);
			//preparedStatementDeleteDynamic.executeUpdate();
			
			
			/* 4. UPDATE queries */
			// dynamic update
			//PreparedStatement preparedStatementUpdateDynamic = con.prepareStatement(updateQueryDynamic);
			//preparedStatementUpdateDynamic.setInt(1, inputIdForUpdate);
			//preparedStatementUpdateDynamic.executeUpdate();
			
			
			/* close connections */
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
