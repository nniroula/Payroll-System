DROP DATABASE IF EXISTS eps_db;
create database eps_db;
use eps_db;


DROP TABLE IF EXISTS employee;

-- table for app version - 3
-- CREATE TABLE employee(employee_id INTEGER, name VARCHAR(50), status VARCHAR(50), payRate VARCHAR(25));

-- Updated table columns for app version - 4
CREATE TABLE employee(employee_id INTEGER, name VARCHAR(50), status VARCHAR(50), payRate VARCHAR(25), hours VARCHAR(25), salary VARCHAR(20));

		
				