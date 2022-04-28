package org.example.demo.service;

import org.example.demo.model.Employee;
import org.example.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Collection;

@Component(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        employeeRepository.createEmployee(employee);
    }

    @Override
    public Collection<Employee> getAllEmployees() throws SQLException {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee findEmployeeById(int id) throws SQLException {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Employee findEmployeeByFirstName(String firstName) throws SQLException {
        return employeeRepository.findEmployeeByFirstName(firstName);
    }

    @Override
    public void updateEmployeeById(Employee employee) throws SQLException {
        employeeRepository.updateEmployeeById(employee);
    }

    @Override
    public void deleteEmployeeById(int id) throws SQLException {
        employeeRepository.deleteEmployeeById(id);
    }
}
