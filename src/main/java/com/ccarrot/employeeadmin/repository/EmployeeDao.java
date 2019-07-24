package com.ccarrot.employeeadmin.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ccarrot.employeeadmin.model.Employee;

@Component
public class EmployeeDao {
	List<Employee> employees = new ArrayList<>();
	
	public EmployeeDao() {
		this.employees.add(new Employee(1l, "Ernesto Ponce", "945689698", "ernesto@gmail.com"));
		this.employees.add(new Employee(2l, "Aldeano Hilera", "864253987", "aldeano@gmail.com"));
		this.employees.add(new Employee(3l, "Enrique Segoviano", "9963258745", "enrique@gmail.com"));
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public Employee getEmployee(Long id) {
		return this.employees.stream()
				.filter(e -> e.getEmployeeId() == id)
				.findFirst()
				.orElse(null);
	}

	public void saveEmployee(Employee emp) {
		if(this.employees.stream().anyMatch(e -> e.getEmployeeId() == emp.getEmployeeId())) {
			this.employees.stream()
			.filter(e -> e.getEmployeeId() == emp.getEmployeeId())
			.forEach(e -> {
				e.setNombres(emp.getNombres());
				e.setTelefono(emp.getTelefono());
				e.setEmail(emp.getEmail());
			});
		}else {
			emp.setEmployeeId(this.employees.size()+1l);
			this.employees.add(emp);
		}
	}

	public void deleteEmployee(Long id) {
		this.employees.removeIf(e -> e.getEmployeeId() == id);
	}

}
