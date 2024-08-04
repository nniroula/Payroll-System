package epsV1;

public class PartTimeEmployee extends Employee{
	private int hoursWorked;
	private double hourlyPayRate;
	
	PartTimeEmployee(String name, int id, int workedHours, double hourlyRate){
		super(name, id);
		this.hoursWorked = workedHours;
		this.hourlyPayRate = hourlyRate;
	}

	@Override
	double calculateSalary() {
		double grossPay = hoursWorked * hourlyPayRate;
		return grossPay;
	}
}
