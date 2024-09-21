package eps.v9_hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* Java is Object Oriented Programming language. So, create a class to use it as an Object to persist data in database */

// this makes table named employeeModal in the relational database
@Entity
@Table(name="employee_hibernate_table")
public class EmployeeModal {
	@Id
	@Column(name="emp_id")
	private int employeeId;
	
	@Column(name="emp_name")
	private String employeeName;
	
	@Column(name="hours_worked")
	private int employeeHoursWorked;
	
	@Column(name="hourly_rate")
	private double employeeHourlyWage;
	
	@Column(name = "salary")
	private double employeeSalary;
	
	@Column(name="status")
	private String employeeStatus;
	
	// no argument constructor - must have if you are using parameterized constructor below
	public EmployeeModal() { }
	
	//parameterized constructor
	public EmployeeModal(int id, String name, String status, int hours, double hourlyRate, double salary) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeHoursWorked = hours;
		this.employeeHourlyWage = hourlyRate;
		this.employeeSalary = salary;
		this.employeeStatus = status;
	}
	
	//getters
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public int getEmployeeHoursWorked() {
		return employeeHoursWorked;
	}
	
	public double getEmployeeHourlyWage() {
		return employeeHourlyWage;
	}
	
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	
	//setters
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setEmployeeHoursWorked(int employeeHoursWorked) {
		this.employeeHoursWorked = employeeHoursWorked;
	}
	
	public void setEmployeeHourlyWage(double employeeHourlyWage) {
		this.employeeHourlyWage = employeeHourlyWage;
	}
	
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	//toString
	@Override
	public String toString() {
		return "DataModel [employeeName=" + employeeName + ", employeeId=" + employeeId + ", employeeHoursWorked="
				+ employeeHoursWorked + ", employeeHourlyWage=" + employeeHourlyWage + ", employeeSalary="
				+ employeeSalary + ", employeeStatus=" + employeeStatus + "]";
	}

}
