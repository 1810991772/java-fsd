package org.example.spring_jdbc.service;

import java.sql.SQLException;

import org.example.spring_jdbc.model.Employee;

public interface EmployeeService {

	public Employee findEmployeeById(int id) throws SQLException;

	public java.util.Collection<Employee> getAllEmployees() throws SQLException;
	public void createEmployee(Employee employee) throws SQLException;
}
