package com.ccarrot.employeeadmin.service;

import java.util.List;

import com.ccarrot.employeeadmin.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(Long employeeId);
	public void saveEmployee(Employee employee);
	public void deleteEmployee(Long employeeId);

}
