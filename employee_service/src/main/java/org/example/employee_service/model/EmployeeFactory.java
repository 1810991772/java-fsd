package org.example.employee_service.model;

public interface EmployeeFactory {
public Employee createEmployee(int employeeId,String employeeName,double salary);
	
	public Employee[] fetchAllEmployees();
	
	public void findEmployeeById(int employeeId);
}
