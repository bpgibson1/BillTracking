package dmacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import dmacc.beans.Bill;
import dmacc.beans.Employee;
import dmacc.repository.BillRepository;
import dmacc.repository.EmpRepository;

/**
 * @author krebs jjkrebs1
 * CIS 175 - Fall 2021
 * Dec 7, 2021
 */
@Controller
public class EmpWebController {
@Autowired
EmpRepository repo;
	
	//methods for the creation of employees
	@GetMapping("/inputEmp")
	public String inputEmployee(Model model) {
		
		Employee e = new Employee();
		model.addAttribute("newEmp", e);
		return "inputEmployee";
	}
	
	@GetMapping("/viewAllEmp")
	public String viewAllEmp(Model model) {
		if(repo.findAll().isEmpty()) { return inputEmployee(model); }
		
		model.addAttribute("employees", repo.findAll());
		return "employeeResults";
	}
	
	@PostMapping("/updateEmp/{id}") 
	 public String reviseEmp(Employee e, Model model) { 
	  repo.save(e); 
	  return viewAllEmp(model); 
	 }
}
