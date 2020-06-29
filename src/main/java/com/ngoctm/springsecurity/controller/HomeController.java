package com.ngoctm.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
		
		return "index";
	}
	
	
	// add request maping for /leaders
	@GetMapping("/leaders")
	public String goLeaderPage() {
		
		return "leader";
	}
	
	// add request maping for /systems
	@GetMapping("/systems")
	public String goAdminPage() {
		
		return "leader";
	}
	
	
}
