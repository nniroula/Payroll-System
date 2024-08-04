package epsV2;

abstract class Employee {
	private String name;
	private int id;
	
	Employee(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	// abstract methods
	abstract double calculateSalary();
	abstract String displaySalary();

	@Override
	public String toString() {
		return "Employee - [name=" + name + ", id=" + id + "]";
	}
	
	
}
