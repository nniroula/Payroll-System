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

		// add employee modal object to database
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeModal.class);

		// Session is an interface and you cannot instantiate it. Search for a class that implements it
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		//session.beginTransaction();
		
		// to use save data to db, changes should be part of transaction with the database
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			//session.save(employeeModalObject); 	// save (hibernate method) does not work
			session.persist(employeeModalObject);	 // persist() is JPA method
			transaction.commit();
		}catch(RuntimeException e) {
			transaction.rollback();
			throw e;  // OR you can display error message
		}finally {
			session.close();
		}
	
		return employeeModalObject;
	}
}
