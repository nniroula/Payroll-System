package epsV4;
import java.util.Scanner;

public class EmployeeDataIO {
		Scanner scannerObject = new Scanner(System.in);
		
		private String employeeName;
		private int employeeId;
		private int employeeHoursWorked;
		private double employeeHourlyWage;
		private double employeeSalary;
		private String employeeStatus;
		
		public void getUserInputData() {
			System.out.print("Enter employee name: ");
			employeeName = scannerObject.nextLine();
			
			System.out.print("Enter emplyee id: ");
			employeeId = scannerObject.nextInt();
			scannerObject.nextLine(); // use this to consume newline character that nextInt does not consume
			
			System.out.print("Enter employee status: ");
			employeeStatus = scannerObject.nextLine();
			
			if(!(employeeStatus.equalsIgnoreCase("full time") || employeeStatus.equalsIgnoreCase("salaried") || employeeStatus.equalsIgnoreCase("fulltime"))) {
				System.out.print("Enter hourly pay rate: ");
				employeeHourlyWage = scannerObject.nextDouble();
				
				System.out.print("Enter total hours worked: ");
				employeeHoursWorked = scannerObject.nextInt();
				
				employeeSalary = employeeHourlyWage * employeeHoursWorked;
			}else {
				System.out.print("Enter salary: ");
				employeeSalary = scannerObject.nextDouble();
			}
		}

		/* getters */
		public String getEmployeeName() {
			return employeeName;
		}

		public int getEmployeeId() {
			return employeeId;
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
		
}
