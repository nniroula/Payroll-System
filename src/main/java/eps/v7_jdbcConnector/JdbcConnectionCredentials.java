package eps.v7_jdbcConnector;

import java.sql.Connection;
import java.sql.DriverManager;

/* final class cannot be extended or inherited 
 * final variable -> to create constant variable
 * final method -> to prevent method overriding
 * final class -> to prevent inheritance
 * */

/* NOTE: In another file, import this package and use JdbcConnectionCredentials.connectJdbc(); */

final public class JdbcConnectionCredentials {
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/eps_db";
	private static String username = "root"; // Replace root with your mysql username
	
	/* Replace root with your mySQl password */
	//private static String password = "root";
	private static String password = "Mysql#23"; 

	
	/* best approach */
	static Connection connection = null;
	static String driver = "com.mysql.cj.jdbc.Driver";
	
	public static Connection connectJdbc() throws Exception{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		connection = DriverManager.getConnection(jdbcUrl, username, password);
		return connection;
	}
}
