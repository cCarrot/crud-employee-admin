package com.ccarrot.employeeadmin.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccarrot.employeeadmin.model.Employee;

@Repository
public class EmployeeEM {

	@Autowired
	EntityManager em;
	
	public List<Employee> getAllEmployees(){
		return em
		       .createQuery("SELECT e FROM Employee e", Employee.class)
		       .setHint("javax.persistence.fetchgraph", em.getEntityGraph("graph.Employee.area"))
		       .getResultList();
	}
	
	public Employee getEmployeeById(Long employeeId){
		/*EntityGraph entityGraph = em.getEntityGraph("graph.Employee.area");
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", entityGraph);
		return em.find(Employee.class, employeeId, properties);*/
		
		return em
				.createQuery("select e from Employee e where e.employeeId = :id", Employee.class)
				.setParameter("id", employeeId)
				.setHint("javax.persistence.fetchgraph", em.getEntityGraph("graph.Employee.area"))
				.getSingleResult();
	}
	

}
