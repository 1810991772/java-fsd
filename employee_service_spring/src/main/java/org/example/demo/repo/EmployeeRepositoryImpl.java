package org.example.demo.repo;

import org.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Collection;

@Component(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createEmployee(Employee employee) throws SQLException {
    	jdbcTemplate.update("insert into employee(firstName,lastName,email) values(?,?,?)", new Object[]{employee.getFirstName(),employee.getLastName(),employee.getEmail()});

        System.out.println("Employee created successfully...");
    }

    @Override
    public Collection<Employee> getAllEmployees() throws SQLException {
        Collection<Employee> employees = jdbcTemplate.query("select * from employee", new EmployeeMapper());
        return employees;

    }

    @SuppressWarnings("deprecation")
	@Override
    public Employee findEmployeeById(int id) throws SQLException {
        return jdbcTemplate.queryForObject("select * from employee where empId = ?",
                new Object[]{id},
                new EmployeeMapper());
    }

    @SuppressWarnings("deprecation")
	@Override
    public Employee findEmployeeByFirstName(String firstName) throws SQLException {
        return jdbcTemplate.queryForObject("select * from employee where firstName = ?",
                new Object[]{firstName},
                new EmployeeMapper());
    }

    @Override
    public void updateEmployeeById(Employee employee) throws SQLException {
        jdbcTemplate.update("update employee set firstName = ?, lastName = ?, email = ?",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail());

        System.out.println("Employee " + employee.getEmpId() + "Updated successfully...");
    }

                             
	@Override
    public void deleteEmployeeById(int id) throws SQLException {
		jdbcTemplate.update("delete from employee where empId =?",id);
        System.out.println("Employee deleted successfully...");
    }
}
