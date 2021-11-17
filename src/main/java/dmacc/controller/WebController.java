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

@Controller
public class WebController {
	
	@Autowired
	//TODO create repo
	
	// should be used for testing, only the manager should see all results
	@GetMapping("viewAll")
	public String viewAllBills(Model model) {
		
		/*
		 * if(repo.findAll().isEmpty()) { return loginScreen(model); }
		 */
		
		//model.addAttribute("bills", repo.findAll());
		return "allResults";
	}
	
	@GetMapping({"/", "loginScreen"})
	public String loginScreen(Model model) {
		
		//TODO: this will only display login screen with manager, employee, and customer links
		
		return "login";
	}
}
