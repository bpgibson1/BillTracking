/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Nov 16, 2021
 */
package dmacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import dmacc.beans.Bill;
import dmacc.repository.BillRepository;

@Controller
public class WebController {
	
	@Autowired
	BillRepository repo;
	
	// should be used for testing, only the manager should see all results
	@GetMapping("viewAll")
	public String viewAllBills(Model model) {
		
		
		if(repo.findAll().isEmpty()) { return loginScreen(model); }
		 
		
		model.addAttribute("bills", repo.findAll());
		return "results";
	}
	
	@GetMapping({"/", "loginScreen"})
	public String loginScreen(Model model) {
		
		//TODO: this will only display login screen with manager, employee, and customer links
		
		return "login";
	}
	
	@GetMapping("/customerAuth")
	public String loginCustomer(Model model) {
		
		//TODO: this will only display login screen with manager, employee, and customer links
		
		return "customerAuth";
	}
	
	@GetMapping("/managerAuth")
	public String loginManager(Model model) {
		
		//TODO: this will only display login screen with manager, employee, and customer links
		
		return "customerAuth";
	}
	
	@GetMapping("/inputBill")
	public String addNewBill(Model model) {
		
		Bill b = new Bill();
		model.addAttribute("newBill", b);
		return "input";
	}
	//This will need fixed, problem with merge
  
	@PostMapping("/inputBill")
	public String addNewBill(@ModelAttribute Bill b, Model model) {
		repo.save(b);
		return viewAllBills(model);
	}
	
	@GetMapping("/edit/{id}") 
	 public String updateBill(@PathVariable("id") long id, Model model) { 
	  Bill b = repo.findById(id).orElse(null); 
	  model.addAttribute("newBill", b); 
	  return "input"; 
	 }
	
	@PostMapping("/update/{id}") 
	 public String reviseBill(Bill b, Model model) { 
	  repo.save(b); 
	  return viewAllBills(model); 
	 }
	
	@GetMapping("/delete/{id}") 
	 public String deleteUser(@PathVariable("id") long id, Model model) { 
		Bill b = repo.findById(id).orElse(null); 
		repo.delete(b); 
		return viewAllBills(model);
	}

	@GetMapping("/payBill/{id}")
	public String payBill(@PathVariable("billId") long billId, Model model) {
		
		Bill b = repo.findById(billId).orElse(null);
		b.setPaid(1);
		return "cc_call";		
	}
	
	public String viewBillByEmployee(long id, Model model) {
		
		model.addAttribute("bills", repo.findById(id));
		return "results";
	}
	
}
