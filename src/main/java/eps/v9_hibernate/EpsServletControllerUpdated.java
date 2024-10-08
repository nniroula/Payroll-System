package eps.v9_hibernate;

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


/**
 * Servlet implementation class EpsServletController
 */
//@WebServlet("/employees")
public class EpsServletControllerUpdated extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EpsServletControllerUpdated() {
        System.out.println("Payroll Sysetm Servlet - version 9 - ORM - Hibernate ");
    }
    
    private String employeeIdInput;
    private String employeeNameInput;
    private String empStatusFromIndexJspFile;
    private String empRateFromIndexJspFile;
    private String hoursWorkedFromIndexJspFile;
    private String empSalaryFromIndexJspFile;
    private Double calculatedSalary;
    
    //model class to receive data from jsp. Data from model class will be sent to database
    EmployeeModal modelEmployee = new EmployeeModal();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  	
    	employeeIdInput = request.getParameter("EmpID");
		request.setAttribute("idFromIndexJspFile", employeeIdInput); // to display in jsp
		RequestDispatcher rd = request.getRequestDispatcher("employeeData.jsp");
		
		//name processing
		employeeNameInput = request.getParameter("EmpName");
		request.setAttribute("nameFromIndexJspFile", employeeNameInput);
		
		//EmpStatus status processing
		empStatusFromIndexJspFile = request.getParameter("EmpStatus");
		request.setAttribute("statusFromIndexJspFile", empStatusFromIndexJspFile);
		
		// hourly rate processing EmpRate
		empRateFromIndexJspFile = request.getParameter("EmpRate");
		request.setAttribute("payRateFromIndexJspFile", empRateFromIndexJspFile);
		
		// hours worked 
		hoursWorkedFromIndexJspFile = request.getParameter("EmpTotalHours");
		request.setAttribute("totalHoursFromIndexJspFile", hoursWorkedFromIndexJspFile);
		
		//salary retrieval and manipulation EmpSalary
		empSalaryFromIndexJspFile = request.getParameter("EmpSalary");
		
		// process gross pay or salary
		if(!(empStatusFromIndexJspFile.equalsIgnoreCase("full time") || empStatusFromIndexJspFile.equalsIgnoreCase("salaried") || empStatusFromIndexJspFile.equalsIgnoreCase("fulltime"))) {
			calculatedSalary = Double.parseDouble(empRateFromIndexJspFile)* Double.parseDouble(hoursWorkedFromIndexJspFile);
		}else {
			calculatedSalary = Double.parseDouble(empSalaryFromIndexJspFile);
		}
		request.setAttribute("calculatedSalary", calculatedSalary);
		
		/* Dao and model classes implementation */
		
		// EmployeeDao class has a method that returns EmployeeModal class type object
		// save this object to database
		
		EmployeeDao employeeDaoObject = new EmployeeDao();
		EmployeeModal newEmployee = employeeDaoObject.createEmployee(Integer.parseInt(employeeIdInput), 
											employeeNameInput, 
											empStatusFromIndexJspFile, 
											Double.parseDouble(empRateFromIndexJspFile), 
											Integer.parseInt(hoursWorkedFromIndexJspFile), 
											calculatedSalary);
		
		System.out.println("Employee Object created in Servlet version - 9 is as below: ");
		System.out.println(newEmployee);
		
		// fetch employee
		employeeDaoObject.getEmployeeFromDb();
		
		//upate employee info using DAO class
		employeeDaoObject.updateEmployeeInfo();
		
		//delete employee
		employeeDaoObject.deleteEmployee();
		
		rd.forward(request, response);
	}
}

