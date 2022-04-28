package org.example.spring_jdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.example.spring_jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) throws SQLException {
		
		jdbcTemplate.update("insert into employee(name) values(?)",new Object[] {employee.getEmployeeName()});
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee findEmployeeById(int id) throws SQLException{
		
		Employee employee = (Employee) this.jdbcTemplate.queryForObject(
			    "select * from employee where id = ?",
			    new Object[]{id},
			    new RowMapper<Object>() {

			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			            Employee employee = new Employee();
			            employee.setEmployeeId(rs.getInt(1));
			            employee.setEmployeeName(rs.getString(2));
			            return employee;
			        }
			    });
		return employee;
	}

	@Override
	public Collection<Employee> getAllEmployees() throws SQLException {
		Collection<Employee> employees=
				jdbcTemplate.query("select * from employee", new EmployeeMapper());
		return employees;
	}
}