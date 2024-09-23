package eps.v10_JpaAndHibernate;

import java.sql.*;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import eps.v9_hibernate.EmployeeModal;

//import eps.v6_dao.JdbcCredential;
//import eps.v7_jdbcConnector.*;

//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;


// Each Dao class represents one table in database
public class EmployeeJpaDao {
	
	EmployeeModal employeeModalObject = new EmployeeModal();
	
	// setup JPA entity manager db connection
	public EntityManager establishJpaEntityManagerDbConnection() {
		// JPA annotations to establish database connection
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); // pu comes from JPA persistence file
		//PersistenceProvider provider = new HibernatePersistenceProvider();
		EntityManager entityManager = emf.createEntityManager();
		
		return entityManager;
	}
	
	/* CRUD Operations in Hibernate */
	
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
	/*
	public EmployeeModal getEmployeeFromDb() {
		EmployeeModal employeeFromDb = new EmployeeModal();
		
		transaction.commit();
		System.out.println("Employee fetched from database is below: ");
		System.out.println(employeeFromDb);
		
		
		//JPA implementation
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		employeeFromDb = em.find(EmployeeJpaModal.class, 1);
		
		return employeeFromDb;
	}
	*/
	
	/* 3. update data */
	/*
	public EmployeeJpaModal updateEmployeeInfo() {
		Session session = establishHibernateSession();
		Transaction tx = session.beginTransaction();
		EmployeeJpaModal empModal = new EmployeeJpaModal();
		
		// retrieve employee from database and set its upated value
		empModal = (EmployeeJpaModal) session.get(EmployeeJpaModal.class, 1);   // 1 is employee id in database
		empModal.setEmployeeName("Newbie Programmer ");
		session.persist(empModal);
		tx.commit();
		
		System.out.println("Updated Employee data is below: ");
		System.out.println(empModal);
		
		return empModal;
	}
	*/
	
	/* 4. Delete CRUD Operation */
	/*
	public void deleteEmployee() {
		Session session = establishHibernateSession();
		Transaction tx = session.beginTransaction();
		EmployeeJpaModal empModal = session.get(EmployeeJpaModal.class, 2);
		//session.delete(empModal); // delete is hibernate method, but does not work
		session.remove(empModal);
		tx.commit();
	}
	*/
}

