package epsV1;

import java.util.ArrayList;
import java.util.List;

// setup employee for the payroll
public class EmployList {
	List<Employee> employeeList;
	EmployList(){
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public String removeEmployee(int id) {
		for(Employee employee: employeeList) {
			if(employee.getId() == id) {
				employeeList.remove(employee);
				break;
			}else {
				return "Employee not found";
			}
		}
		return "Employee with id " + id + " successfully removed!";
	}
	
	// display employee list
	public List<Employee> displayListOfEmployees(){
		return employeeList;
	}
}
