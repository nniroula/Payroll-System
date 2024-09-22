package eps.v9_hibernate;

import java.sql.*;

import eps.v6_dao.JdbcCredential;
import eps.v7_jdbcConnector.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


// Each Dao class represents one table in database
public class EmployeeDao {
	
	EmployeeModal employeeModalObject = new EmployeeModal();
	
	// setup hibernate session
	public Session establishHibernateSession() {
		// always check your annotated class
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeModal.class);

		// Session is an interface and you cannot instantiate it. Search for a class that implements it
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	/* CRUD Operations in Hibernate */
	
	/* 1. Create */
	// returns EmployeeModal class object
	public EmployeeModal createEmployee(int id, String name, String status, double rate, int hours, double salary) {
		
		// hibernate - CRUD Operatrions 
		
		// set values to employee model class
		employeeModalObject.setEmployeeId(id);
		employeeModalObject.setEmployeeName(name);
		employeeModalObject.setEmployeeStatus(status);
		employeeModalObject.setEmployeeHourlyWage(rate);
		employeeModalObject.setEmployeeHoursWorked(hours);
		employeeModalObject.setEmployeeSalary(salary);
		
		Session session = establishHibernateSession();
		
		// to use save data to db, changes should be part of transaction with the database
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			//session.save(employeeModalObject); 	// save (hibernate method) does not work
			session.persist(employeeModalObject);	 // persist() is JPA method
			transaction.commit();
		}catch(RuntimeException e) {
			if(transaction != null) {
			transaction.rollback();
			}
			throw e;  // OR you can display error message
		}finally {
			session.close();
		}
	
		return employeeModalObject;
	}
	
	/* 2 Retrieve data from database */
	public EmployeeModal getEmployeeFromDb() {
		Session session = establishHibernateSession();
		Transaction transaction = session.beginTransaction();
		EmployeeModal employeeFromDb = new EmployeeModal();
		
		employeeFromDb =  session.get(EmployeeModal.class, 1); // annotated class and an id of an object in database
		
		transaction.commit();
		System.out.println("Employee fetched from database is below: ");
		System.out.println(employeeFromDb);
		
		return employeeFromDb;
	}
	
	/* 3. update data */
	public EmployeeModal updateEmployeeInfo() {
		Session session = establishHibernateSession();
		Transaction tx = session.beginTransaction();
		EmployeeModal empModal = new EmployeeModal();
		
		// retrieve employee from database and set its upated value
		empModal = (EmployeeModal) session.get(EmployeeModal.class, 1);   // 1 is employee id in database
		empModal.setEmployeeName("Newbie Programmer ");
		session.persist(empModal);
		tx.commit();
		
		System.out.println("Updated Employee data is below: ");
		System.out.println(empModal);
		
		return empModal;
	}
	
	public void deleteEmployee() {
		Session session = establishHibernateSession();
		Transaction tx = session.beginTransaction();
		EmployeeModal empModal = session.get(EmployeeModal.class, 2);
		//session.delete(empModal); // delete is hibernate method, but does not work
		session.remove(empModal);
		tx.commit();
	}
}
