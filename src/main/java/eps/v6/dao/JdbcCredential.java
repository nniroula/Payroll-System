package eps.v6.dao;

/* final class cannot be extended or inherited 
 * final variable -> to create constant variable
 * final method -> to prevent method overriding
 * final class -> to prevent inheritance
 * */

final public class JdbcCredential {
	private String jdbcUrl = "jdbc:mysql://localhost:3306/eps_db";
	private String username = "root"; // Replace root with your mysql username
	String password = "root"; // Replace root with your mySQl password
	
	final public String getJdbcUrl() {
		return jdbcUrl;
	}
	
	final public String getUsername() {
		return username;
	}

	final public String getPassword() {
		return password;
	}

}
