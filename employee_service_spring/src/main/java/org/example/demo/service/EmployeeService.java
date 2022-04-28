package org.example.demo.service;

import org.example.demo.model.Employee;

import java.sql.SQLException;
import java.util.Collection;

public interface EmployeeService {
    public void createEmployee(Employee employee) throws SQLException;
    public Collection<Employee> getAllEmployees() throws SQLException;
    public Employee findEmployeeById(int id) throws SQLException;
    public Employee findEmployeeByFirstName(String firstName) throws SQLException;
    public void updateEmployeeById(Employee employee) throws SQLException;
    public void deleteEmployeeById(int id) throws SQLException;
}
