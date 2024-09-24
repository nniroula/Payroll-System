package eps.v10_JpaAndHibernate;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import eps.v9_hibernate.EmployeeModal;


// Each Dao class represents one table in database
public class EmployeeJpaDao {
	
	EmployeeModal employeeModalObject = new EmployeeModal();
	
	// setup JPA entity manager db connection
	public EntityManager establishJpaEntityManagerDbConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); // pu comes from JPA persistence file
		EntityManager entityManager = emf.createEntityManager();
		
		return entityManager;
	}
	
	/* CRUD Operations in Hibernate using JPA Annotations */
	
	/* 1. Create */
	// returns EmployeeModal class object
	public EmployeeModal createJpaEmployee(int id, String name, String status, double rate, int hours, double salary) {
		// set values to employee model class
		employeeModalObject.setEmployeeId(id);
		employeeModalObject.setEmployeeName(name);
		employeeModalObject.setEmployeeStatus(status);
		employeeModalObject.setEmployeeHourlyWage(rate);
		employeeModalObject.setEmployeeHoursWorked(hours);
		employeeModalObject.setEmployeeSalary(salary);
		
		EntityManager entityManager = establishJpaEntityManagerDbConnection();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(employeeModalObject);
			entityManager.getTransaction().commit();
		}catch(RuntimeException e) {
			throw e;  // OR you can display error message
		}finally {
			entityManager.close();
		}
	
		return employeeModalObject;
	}
	
	
	/* 2 Retrieve data from database */
	
	public EmployeeModal getJpaEmployeeFromDb() {
		EmployeeModal employeeFromDb;
		EntityManager entityManager = establishJpaEntityManagerDbConnection();
		
		try {
			employeeFromDb = entityManager.find(EmployeeModal.class, 1); // annotated modal class and object's primary key in db
		}catch(RuntimeException e) {
			throw e;  // OR you can display error message
		}finally {
			entityManager.close();
		}
		
		return employeeFromDb;
	}

	
	/* 3. update data in the database*/
	
	public EmployeeModal updateJpaEmployeeInfo() {
		EntityManager entityManager = establishJpaEntityManagerDbConnection();
		EmployeeModal employeeToBeUpdated = new EmployeeModal();
		String updatedEmployeeName = "New Java Developer";
		try {
			entityManager.getTransaction().begin();
			employeeToBeUpdated = entityManager.find(EmployeeModal.class, 1);
			employeeToBeUpdated.setEmployeeName(updatedEmployeeName);
			entityManager.getTransaction().commit();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		System.out.println("Updated Employee data is below: ");
		
		return employeeToBeUpdated;
	}
	
	
	/* 4. Delete CRUD Operation */
	
	public void deleteJpaEmployee() {
		EntityManager entityManager = establishJpaEntityManagerDbConnection();
		EmployeeModal employeeToBeDeleted = new EmployeeModal();
		try {
			entityManager.getTransaction().begin();
			employeeToBeDeleted = entityManager.find(EmployeeModal.class, 1);
			entityManager.getTransaction().commit();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		System.out.println("Successfully Deleted employee with id of " + employeeToBeDeleted.getEmployeeId());
	
	}
	
}

