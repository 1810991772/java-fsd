package org.example.spring_jdbc.repo;

import java.sql.SQLException;

import org.example.spring_jdbc.model.Employee;

public interface EmployeeRepository {
	
	public void createEmployee(Employee employee) throws SQLException;
	public Employee findEmployeeById(int id) throws SQLException;

	public java.util.Collection<Employee> getAllEmployees() throws SQLException;

}
