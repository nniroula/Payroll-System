package eps.v6_dao;

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
		//modelEmployee.setEmployeeHoursWorked(Integer.parseInt(hoursWorkedFromIndexJspFile));
		
		//salary retrieval and manipulation EmpSalary
		empSalaryFromIndexJspFile = request.getParameter("EmpSalary");
		
		// process gross pay or salary
		if(!(empStatusFromIndexJspFile.equalsIgnoreCase("full time") || empStatusFromIndexJspFile.equalsIgnoreCase("salaried") || empStatusFromIndexJspFile.equalsIgnoreCase("fulltime"))) {
			calculatedSalary = Double.parseDouble(empRateFromIndexJspFile)* Double.parseDouble(hoursWorkedFromIndexJspFile);
		}else {
			calculatedSalary = Double.parseDouble(empSalaryFromIndexJspFile);
		}
		request.setAttribute("calculatedSalary", calculatedSalary);
		
		//Dao and model classes implementation 
		DataInputJspDao daoObject = new DataInputJspDao();
		EmployeeModel newEmp = daoObject.addEmployee(Integer.parseInt(employeeIdInput), 
													employeeNameInput,
													empStatusFromIndexJspFile,
													Double.parseDouble(empRateFromIndexJspFile),
													Integer.parseInt(hoursWorkedFromIndexJspFile),
													calculatedSalary
												);
		System.out.println(newEmp);
		
		rd.forward(request, response);
	}
}

