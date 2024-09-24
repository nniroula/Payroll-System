package eps.v10_JpaAndHibernate;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import eps.v9_hibernate.EmployeeModal;


/**
 * Servlet implementation class EpsServletController
 */
@WebServlet("/employees")
public class EpsServletControllerJpa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EpsServletControllerJpa() {
        System.out.println("Payroll Sysetm Servlet - version 10 - JPA implementation");
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
		if(!(empStatusFromIndexJspFile.equalsIgnoreCase("full time")|| empStatusFromIndexJspFile.equalsIgnoreCase("fulltime"))) {
			calculatedSalary = Double.parseDouble(empRateFromIndexJspFile)* Double.parseDouble(hoursWorkedFromIndexJspFile);
		}else {
			calculatedSalary = Double.parseDouble(empSalaryFromIndexJspFile);
		}
		request.setAttribute("calculatedSalary", calculatedSalary);
		
		/* Dao and model classes implementation */
		
		/* create employee using JPA */
		EmployeeJpaDao employeeJpaDaoObject = new EmployeeJpaDao();
		
		EmployeeModal newEmployee = employeeJpaDaoObject.createJpaEmployee(Integer.parseInt(employeeIdInput), 
											employeeNameInput, 
											empStatusFromIndexJspFile, 
											Double.parseDouble(empRateFromIndexJspFile), 
											Integer.parseInt(hoursWorkedFromIndexJspFile), 
											calculatedSalary);
		
		System.out.println("Employee Object created in Servlet version - 10 is as below: ");
		System.out.println(newEmployee);
		
		
		/* fetch JPA employee */
		EmployeeModal jpaEmployeeFromDb = employeeJpaDaoObject.getJpaEmployeeFromDb();
		System.out.println("Fetching employee using JPA as follws: ");
		System.out.println(jpaEmployeeFromDb);
		
		/* upate employee info using JPA DAO class */
		EmployeeModal updatedJpaEmployee = employeeJpaDaoObject.updateJpaEmployeeInfo();
		System.out.println(updatedJpaEmployee);
		
		/* delete employee using JPA Dao class */
		employeeJpaDaoObject.deleteJpaEmployee();
		
		rd.forward(request, response);
	}
}

