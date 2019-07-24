package com.ccarrot.employeeadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccarrot.employeeadmin.model.Employee;
import com.ccarrot.employeeadmin.repository.EmployeeEM;
import com.ccarrot.employeeadmin.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	/*@Autowired
	EmployeeDao empDao;*/
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeEM emp;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getEmployees() {
		//return this.empDao.getEmployees();
		//return this.employeeRepository.findAll();
		return this.employeeRepository.getAllEmployees();
		//return this.emp.getAllEmployees();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee getEmployeeById(Long employeeId) {
		//return this.empDao.getEmployee(employeeId);
		//return this.employeeRepository.findById(employeeId).orElse(null);
		return this.emp.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		//this.empDao.saveEmployee(employee);
		this.employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(Long employeeId) {
		//this.empDao.deleteEmployee(employeeId);
		this.employeeRepository.deleteById(employeeId);
	}


}
