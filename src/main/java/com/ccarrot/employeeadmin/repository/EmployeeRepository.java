package com.ccarrot.employeeadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccarrot.employeeadmin.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@EntityGraph(attributePaths = {"area"})
	@Query("SELECT e FROM Employee e")
	public List<Employee> getAllEmployees();
	
	@EntityGraph(attributePaths = {"area"})
	@Query("SELECT e FROM Employee e WHERE e.employeeId=:id")
	public Employee getEmployeeByIdWithArea(@Param("id") Long employeeId);
	
}
