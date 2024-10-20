package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.CandidateService;
import com.service.PersonalDetailsService;
import com.model.*;
import java.util.List;
import com.service.*;
import com.repository.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

@Controller
public class AdminController {
	
	@Autowired
	private CandidateService canServ;

	//new

	@Autowired
	private PersonalDetailsService personalDetailsService;
//	@GetMapping("/admin")
//	public String dashboard(Model m, Principal p)
//	{
//
//
//		// total votes
//		int c1 = canServ.getNumOfVotes("candidate1");
//		int c2 = canServ.getNumOfVotes("candidate2");
//		int c3 = canServ.getNumOfVotes("candidate3");
//		int c4 = canServ.getNumOfVotes("candidate4");
//
//
//		m.addAttribute("c1", c1);
//		m.addAttribute("c2", c2);
//		m.addAttribute("c3", c3);
//		m.addAttribute("c4", c4);
//
//		m.addAttribute("title","DASHBOARD");
//
//
//		return "admin/dashboard";
//
//
//	}
	@GetMapping("/view")
	public String viewPage() {
		return "view"; // Return the name of the HTML file without the .html extension
	}
	@GetMapping("/update")
	public String updatePage() {
		return "updateform"; // Return the name of the HTML file without the .html extension
	}
	@GetMapping("/addemployee")
	public String addemployee() {
		return "addemployee"; // Return the name of the HTML file without the .html extension
	}


	// Method to display all employees on the dashboard
	@GetMapping("/admin")
	public String showEmployeeDashboard(Model model) {
		List<PersonalDetails> employeeList = personalDetailsService.getAllEmployees(); // Fetching all employees
		model.addAttribute("employees", employeeList); // Adding employees to the model
		return "admin/dashboard"; // Render the admin/dashboard.html template
	}





}
