package epsV1;

public class FullTimeEmployee extends Employee{
	private double monthlySalary;

	FullTimeEmployee(String name, int id, double monthlyPay) {
		super(name, id);
		this.monthlySalary = monthlyPay;
	}

	// this is the abstract method from Employee class
	@Override
	double calculateSalary() {
		return monthlySalary;
	}
	
}
