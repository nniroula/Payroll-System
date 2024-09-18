package eps.v8_refactoredCode;

/* Java is Object Oriented Programming language. So, create a class to use it as an Object */
public class EmployeeModel {
	private int employeeId;
	private String employeeName;
	private int employeeHoursWorked;
	private double employeeHourlyWage;
	private double employeeSalary;
	private String employeeStatus;
	
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
	
	public void print() {
		System.out.println("IDDDDDDD in Model....");
		System.out.println(employeeId);
	}

}
