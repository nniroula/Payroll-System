package epsV2;

import java.util.Scanner;

public class PartTimeEmployeeDataIO{
	Scanner scannerObject = new Scanner(System.in);
	
	private String newEmployeeName;
	private int newEmployeeId;
	private int newEmployeeHoursWorked;
	private double newEmployeeHourlyWage;
	
	/* creates a part time employee */
	public Employee createPartTimeEmployee() {
		System.out.print("Enter employee name: ");
		newEmployeeName = scannerObject.next();
		
		System.out.print("Enter emplyee id: ");
		newEmployeeId = scannerObject.nextInt();
		
		System.out.print("Enter total hours worked: ");
		newEmployeeHoursWorked = scannerObject.nextInt();
		
		System.out.print("Enter hourly pay rate: ");
		newEmployeeHourlyWage = scannerObject.nextDouble();
		
		PartTimeEmployee partTimeEmployeeObject = new PartTimeEmployee(newEmployeeName,
									newEmployeeId, newEmployeeHoursWorked, newEmployeeHourlyWage);
		
		return partTimeEmployeeObject;
	}
	
	/*calculates gross pay of a part time employee */
	public double getPartTimeEmployeeGrossPay() {
		Employee newEmployee = createPartTimeEmployee();
		double salary = newEmployee.calculateSalary();
		return salary;
	}
}
