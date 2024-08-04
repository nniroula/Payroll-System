package epsV2;

import java.util.Scanner;

public class FullTimeEmployeeDataIO{
	Scanner scannerObject = new Scanner(System.in);
	
	private String newAssociateName;
	private int newAssociateId;
	private double newAssociateSalary;
	
	/* creates a part time employee */
	public Employee createFullTimeEmployee() {
		System.out.print("Enter full time employee name: ");
		newAssociateName = scannerObject.next();
		
		System.out.print("Enter full time emplyee id: ");
		newAssociateId = scannerObject.nextInt();
		
		System.out.print("Enter full time employee salary: ");
		newAssociateSalary = scannerObject.nextDouble();
		
		// FullTimeEmployee(String name, int id, double monthlyPay)
		FullTimeEmployee fullTimeEmployeeObject = new FullTimeEmployee(newAssociateName,
									newAssociateId, newAssociateSalary);
		
		return fullTimeEmployeeObject;
	}
	
	/*calculates gross pay of a part time employee */
	public double getFullTimeEmployeeGrossPay() {
		Employee newAssociate = createFullTimeEmployee();
		double salary = newAssociate.calculateSalary();
		return salary;
	}
}
