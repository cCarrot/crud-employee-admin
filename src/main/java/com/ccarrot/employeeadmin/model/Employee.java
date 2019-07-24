package com.ccarrot.employeeadmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "employee")
@NamedEntityGraphs({
    @NamedEntityGraph(name = "graph.Employee.area",
            attributeNodes = {@NamedAttributeNode("area")})
})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	//@SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq")
	@Column(name= "employee_id", updatable = false, nullable = false)
	private Long employeeId;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 200)
	@Column(nullable = false)
	private String nombres;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 12)
	@Column(nullable = false)
	private String telefono;
	
	@NotNull
	@NotEmpty
	@Email
	@Column(nullable = false)
	private String email;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;

	public Employee() {
	}
	
	public Employee(Long employeeId, String nombres, String telefono, String email) {
		this.employeeId = employeeId;
		this.nombres = nombres;
		this.telefono = telefono;
		this.email = email;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	

}
