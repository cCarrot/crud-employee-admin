package com.ccarrot.employeeadmin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccarrot.employeeadmin.model.Area;
import com.ccarrot.employeeadmin.model.Employee;
import com.ccarrot.employeeadmin.service.AreaService;
import com.ccarrot.employeeadmin.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	AreaService areaService;

	@GetMapping("/list")
	public String lisEmployees(ModelMap model) {
		model.addAttribute("employees", employeeService.getEmployees());
		return "home";
	}
	
	@GetMapping("/showForm")
	public String showForm(ModelMap model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allAreas", areaService.getAll());
		return "form";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("employeeId") Long id, ModelMap model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("allAreas", areaService.getAll());
		return "form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute Employee emp, BindingResult result, ModelMap model) {
		
        if (result.hasErrors()) {
        	model.addAttribute("allAreas", areaService.getAll());
            return "form";
        }
		
		employeeService.saveEmployee(emp);
		return "redirect:/admin/list";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/admin/list";
	}
	
	/*@ModelAttribute("allAreas")
    public List<Area> populateArea(){
        return areaService.getAll();
    }*/
}
