package epsV5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*
@WebServlet("/employees")
public class EpsServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EpsServletController() {
        System.out.println("Payroll Sysetm Servlet");
    }
    
    private String employeeIdInput;
    private String employeeNameInput;
    private String empStatusFromIndexJspFile;
    private String empRateFromIndexJspFile;
    private String hoursWorkedFromIndexJspFile;
    private String empSalaryFromIndexJspFile;
    private Double calculatedSalary;
    
    //model class to receive data from jsp. Data from model class will be sent to database
    EmployeeModel modelEmployee = new EmployeeModel();

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db
		String jdbcUrl = "jdbc:mysql://localhost:3306/eps_db";
		String username = "root"; // Replace root with your mysql username
		// String password = "root"; // Replace root with your mySQl password
    	
    	employeeIdInput = request.getParameter("EmpID");
		request.setAttribute("idFromIndexJspFile", employeeIdInput);
		RequestDispatcher rd = request.getRequestDispatcher("employeeData.jsp");
		//rd.forward(request, response);
		modelEmployee.setEmployeeId(Integer.parseInt(employeeIdInput));
		
		//name processing
		employeeNameInput = request.getParameter("EmpName");
		request.setAttribute("nameFromIndexJspFile", employeeNameInput);
		modelEmployee.setEmployeeName(employeeNameInput);
		
		//EmpStatus status processing
		empStatusFromIndexJspFile = request.getParameter("EmpStatus");
		request.setAttribute("statusFromIndexJspFile", empStatusFromIndexJspFile);
		modelEmployee.setEmployeeStatus(empStatusFromIndexJspFile);
		
		// hourly rate processing EmpRate
		empRateFromIndexJspFile = request.getParameter("EmpRate");
		request.setAttribute("payRateFromIndexJspFile", empRateFromIndexJspFile);
		modelEmployee.setEmployeeHourlyWage(Double.parseDouble(empRateFromIndexJspFile));
		
		// hours worked 
		hoursWorkedFromIndexJspFile = request.getParameter("EmpTotalHours");
		request.setAttribute("totalHoursFromIndexJspFile", hoursWorkedFromIndexJspFile);
		modelEmployee.setEmployeeHoursWorked(Integer.parseInt(hoursWorkedFromIndexJspFile));
		
		//salary retrieval and manipulation EmpSalary
		empSalaryFromIndexJspFile = request.getParameter("EmpSalary");
		//request.setAttribute("salaryFromIndexJspFile", empSalaryFromIndexJspFile);
		
		// process gross pay or salary
		if(!(empStatusFromIndexJspFile.equalsIgnoreCase("full time") || empStatusFromIndexJspFile.equalsIgnoreCase("salaried") || empStatusFromIndexJspFile.equalsIgnoreCase("fulltime"))) {
			calculatedSalary = Double.parseDouble(empRateFromIndexJspFile)* Double.parseDouble(hoursWorkedFromIndexJspFile);
			modelEmployee.setEmployeeSalary(calculatedSalary);
		}else {
			calculatedSalary = Double.parseDouble(empSalaryFromIndexJspFile);
			modelEmployee.setEmployeeSalary(calculatedSalary);
		}
		request.setAttribute("calculatedSalary", calculatedSalary);
		
		
		// NOT a good idea to use database operation here	
		String insertQuery = "INSERT INTO employee(employee_id, name, status, payRate, hours, salary) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setInt(1, Integer.parseInt(employeeIdInput));
			preparedStatement.setString(2, employeeNameInput);
			preparedStatement.setString(3, empStatusFromIndexJspFile);
			preparedStatement.setDouble(4, Double.parseDouble(empRateFromIndexJspFile));
			preparedStatement.setInt(5, Integer.parseInt(hoursWorkedFromIndexJspFile));
			preparedStatement.setDouble(6, calculatedSalary);
			int count = preparedStatement.executeUpdate();
			if(count > 0) {
				System.out.println("Suucccccess");
			}else {
				System.out.println("Faaaaaaaalse");
			}
			
			con.close();
			preparedStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		rd.forward(request, response);
	}
}
*/

