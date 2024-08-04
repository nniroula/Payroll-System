package epsV3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcRunner {
	public void setupJdbc() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/eps_db"; // Replace eps_db with your database name
		String username = "root"; // Replace root with your mysql username
		String password = "root"; // Replace root with your mySQl password
		
		
		// ----- user input values. Get from console or GUI -------
		int associateId = 3;
		String associateName = "Persistent Coding";
		String status = "Salaried";
		String payRate = "7000.524";
		int inputIdForUpdate = 1;
		int inputIdForDynamicSelect = 1;
		
		/* 1. INSERT queries -> executeUpdate() */
		String insertQueryOne = "INSERT INTO employee(employee_id, name, status, payRate) VALUES(1, 'Nabin', 'Full Time', 5000)";
		String insertQueryTwo = "INSERT INTO employee(employee_id, name, status, payRate) VALUES(2, 'John Doe', 'Part Time', 17.34)";
		String insertQueryThree = "INSERT INTO employee VALUES(?, ?, ?, ?)"; //dynamic approach
		
		
		/* 2.  SELECT queries */
		String selectQuery = "SELECT * FROM employee";
		//Dynamic way
		String selectQueryDynamic = "SELECT * FROM employee WHERE employee_id = ?";
		
		
		/* 3. DELETE queries */
		String deleteQueryOne = "DELETE FROM employee WHERE employee_id = 1";
		//Dynamic approach
		int userSelectedId = 2; // store user input in this
		String deleteQueryDyanmic = "DELETE FROM employee WHERE employee_id = ?"; // provide value for ? in prepared statement
		
		
		/* 4. UPDATE queries */
		String updateQuery = "UPDATE employee SET employee_id = 100, name = 'Coding Craz', status = 'Fired', payRate = '0.0' WHERE employee_id = 3";
		//update query in dynamic way
		String updateQueryDynamic = "UPDATE employee SET employee_id = 500, name = 'Beauty of Programming', status='Underway', payRate = '30.00' WHERE employee_id = ?";
		
		
		try {
			// load the jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			
			PreparedStatement preparedStatementInsertOne = con.prepareStatement(insertQueryOne);
			PreparedStatement preparedStatementInsertTwo = con.prepareStatement(insertQueryTwo);
			PreparedStatement preparedStatementInsertThree = con.prepareStatement(insertQueryThree);
			
			/* 1. INSERT queries -> executeUpdate() */
			int numbersOfRowsAffected = preparedStatementInsertOne.executeUpdate();
			int resultTwo = preparedStatementInsertTwo.executeUpdate();
			// with positional parameters - Dynamic way
			preparedStatementInsertThree.setInt(1, associateId);
			preparedStatementInsertThree.setString(2, associateName);
			preparedStatementInsertThree.setString(3, status);
			preparedStatementInsertThree.setString(4, payRate);
			preparedStatementInsertThree.executeUpdate(); // you do not have to pass in insertQueryThree as it is already passed in above
			
			if(numbersOfRowsAffected > 0){
				System.out.println("result = " + numbersOfRowsAffected);
				System.out.print(", JDBC Connection Successful"); 
			}else if(numbersOfRowsAffected < 0) {
				System.out.println("Failure of jdbc connection");
				System.out.println("result = " + numbersOfRowsAffected);
			}
			
			
			/*2.  SELECT queries */
			ResultSet resultSet = preparedStatementInsertOne.executeQuery(selectQuery);
			int empoyeeIdFromResultSet;
			String employeeNameFromResultSet;
			while(resultSet.next()) {
				empoyeeIdFromResultSet = resultSet.getInt("employee_id");
				employeeNameFromResultSet = resultSet.getString("name");
				System.out.printf("employee id = %d, name = %s", empoyeeIdFromResultSet, employeeNameFromResultSet);
				System.out.println();
			}
			// SELECT Dynamic
			PreparedStatement preparedStatementSelectDynamic = con.prepareStatement(selectQueryDynamic);
			preparedStatementSelectDynamic.setInt(1, inputIdForDynamicSelect);
			ResultSet resultSetDynamicSelect = preparedStatementSelectDynamic.executeQuery();
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
			PreparedStatement preparedStatementDeleteOne = con.prepareStatement(deleteQueryOne);
			preparedStatementDeleteOne.executeUpdate();
			// Dynamic delete approach
			PreparedStatement preparedStatementDeleteDynamic = con.prepareStatement(deleteQueryDyanmic);
			preparedStatementDeleteDynamic.setInt(1, userSelectedId);
			preparedStatementDeleteDynamic.executeUpdate();
			
			
			/* 4. UPDATE queries */
			PreparedStatement preparedStatementUpdate = con.prepareStatement(updateQuery);
			preparedStatementUpdate.executeUpdate();
			// dynamic update
			PreparedStatement preparedStatementUpdateDynamic = con.prepareStatement(updateQueryDynamic);
			preparedStatementUpdateDynamic.setInt(1, inputIdForUpdate);
			preparedStatementUpdateDynamic.executeUpdate();
			
			
			/* close connections */
			preparedStatementInsertOne.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
