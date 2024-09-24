#### Employee Payroll System 
An Employee Payroll System
<hr>

#### Version-1 (eps.v1_oops) 

- This version implements OOP concepts and Static List:-
	- ``Encapsulation`` - private access modifier for instance variables <br>
	- ``Polymorphism`` - abstract method @Override <br>
	- ``Inheritance`` - extends keyword <br>
	- ``Abstraction`` - abstract class inherited in another class and abstract method overridden <br>
	- ``List`` - List data structure to hold employees
	
<hr>	

#### Version-2 (eps.v2_io) 

- This version implements OOP concepts plus following:- 
	- ``I/O`` - gets user input <br>
	- ``Separation of Concern, abstraction and code modularization`` <br>

<hr>

#### Version-3 (eps.v3_jdbcStatic) 

- This version implements the following:- 
	- ``JDBC`` - Java Database Connectivity <br>
		a. use ``MYSQL`` ``RDBMS``. Download MySQL connector jar <br>
		b. add the jar file to the project as an external jar <br>
		c. create a database, database table and connect to that database. <br>
	- ``JDBC`` implementation is ready to work on dynamic data <br>

<hr>

#### Version-4 (eps.v4_jdbcDynamic) 

- This version:- 
	- takes in console input and updates database table accordingly <br>
	- Implements ``JDBC CRUD`` operations <br>
	- To implement Delete and Update functionalities, uncomment the code in eps4>JdbcRunner.java file
	
<hr>

#### How to run a <i>``Seed File``</i> and the project so far? 
- Open this project in Eclipse and run it there
- Open up terminal in your device and type ``mysql`` and hit enter. If this does not work, then run the command ``mysql -u root -p``. Provide password for your MySQL RDBMS. <br>
	-- Then run the command: ``source seed.sql;`` - it's your <i>``SEED FILE``</i> <br>
	-- Use command ``show databases;`` to check your available databases;
	-- Run the command ``use eps_db(your database name);`` to connect to your database <br>
	-- Run the command ``show tables;`` to show available database tables <br>
	-- ``SELECT * FROM employee(or your table name);`` to display the list of items from the database table <br>
	-- Then run the project in Eclipse and provide console input. Check the table as above for the update.
	
<hr>


#### Version-5 (eps.v5_mavenProject) 

- Converted to Maven Project and implemented ``MVC Design Pattern``:-
- ``pom.xml`` - uses pom.xml (Project Object Model) file to manage external jars and library 		dependencies.<br>
- ``Servlet`` - Server side technology. Works as a controller.<br>
- ``TomCat Server`` - Servlet runs on TomCat Server.<br>
- ``JSP`` - To incorporate java code into html file. It's a view. <br>
- ``JSTL`` - Java Standard Template Library for converting java code into html like code<br>
- ``JDBC`` ``RDBMS`` ``MySQL``- For database connectivity <br>
- ``DAO Layer`` - separate database operations from controller into DAO class <br>

<hr>

#### How to run this project(JSP, JSTL, Servlet, JDBC, and MySQL Project)? 

- In ``Eclipse IDE`` and ``Terminal or MySQL Workbench``:-
- In ``Terminal`` or by using MySQL workbench, create a database named eps_db and then create table named employee with columns employee_id, name, status, payRate, hours, and salary.
- Right click on ``index.jsp file`` - Run As - run on server <br>
- Enter the required input <br>
- In ``Terminal`` - run the command ``mysql`` and hit enter. Then show databases; use database_name; select * from employee<br>
- ``NOTE:`` - you may have to uncomment ``ServletController file in epsV5`` if you are running this project up to version 5. <br>
- ``epsV6 and onward``, update your ``mysql`` credentials in ``JdbcCredential.java file``.

<hr>

#### Version-6 (eps.v6_dao) 

- Implements ``DAO (Data Access Object) layer``- to separated ``JDBC`` ``CRUD`` operations from the controller
- Uses ``final class`` concept - to hold mySQL login credentials.<br>
- ``DAO Layer`` - handles database related operations
- NOTE: To run this version:- Uncomment the Controller mapping (@WebServlet("/employees") in EpsServletControllerUpdated.java file

<hr>

#### Version-7 (eps.v7_jdbcConnector) 
- Separates JDBC connection credentials into separate package
- Future packages requiring jdbc connection should use this package

<hr>

#### Version-8 (eps.v8_refactoredCode) 
- Implements ``Separation of Concern principle`` and thus, employs ``Design Patterns`` to implement ``DAO`` layer(Data Access Object Layer) and ``MVC Architecture``. 
- Extracts ``MySQL user Credentials`` that are needed for ``JDBC`` implementation into a separate package
- NOTE: to run this version: uncomment @WebServlet("employees") in EpsServletControllerUpdated.java file. You may have to comment same thing in the subsequent versions.
 
<hr>

#### To Run <i>``MySQL Database``</i> in Mac <i>``Terminal``<i/> 
- In System preference, start MySQL workbench
- if ``mysql`` command does not work in terminal, then use ``mysql -u root -p`` command and enter your mysql password when prompted

<hr>

#### Version-9 (eps.v9_hibernate) 
- Implements ``ORM framework`` called ``Hibernate``- to convert java code into ``SQL queries``
- ``ORM`` connects object modal to Relational Database tables. If you don't know SQL - use ORM. It's all about object to table mapper.
- ``NOTE:`` To run this version:- Replace root with your MySQL password in ``hibernate.cfg.xml`` file
- ``NOTE:`` Also uncomment  @WebServlet("employees") in the Servlet controller class. You may have to comment the same line of code in version 10 to make this version run successfully.
 
<hr>

#### Version-10 (eps.v10_JpaAndHibernate) 
- Implements ``JPA (Java Persistence API) annotations`` with ``Hibernate`` to make Object-Relational(Java Objects to relational database table) mapping an ORM independent construct.
- ``JPA`` is a specification (interface) and is only implemented with ORM framework like Hibernate, TopLinks or iBatis.
- ``NOTE:`` To run this version:- Replace root with your MySQL password in ``persistence.xml`` file. You may have to do the same with ``hibernate.cfg.xml``.
- ``NOTE:`` You may have to uncomment  @WebServlet("employees") in the Servlet controller class of version 9 so that the two controllers do not point to the same API route.

<hr>

#### How to run this project 
- Open up the project in Eclipse
- Make sure all external libraries and jar files are properly installed and configured including ``Tomcat server``, ``MySQL Connector jar``, ``Hibernate``, ``Servlet``, ``JDBC``, ``JSP``, ``JSTL``, ``Maven`` etc.
- Right click on ``index.jsp`` file > Run on Server
- Provide input in the browser.
- Output will be displayed in the browser and mostly on the console.
