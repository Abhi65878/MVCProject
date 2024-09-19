package com.example.kartiksapra.mvcproj.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.kartiksapra.mvcproj.entity.Employee;

@RestController
public class EmployeeController {
	
	@GetMapping("/getForm")
	public ModelAndView getRegisterationForm() {          //ModelAndView return the data and html page.
		
		String viewName = "register";
		Map<String, Object> model = new HashMap<>();
		Employee e = new Employee();
		e.setFirstname("John");
		e.setLastname("Doe");
		model.put("employeeEntry", e);
		
//		model.put("displaykaronaam", "kartik");           //Let suppose this is the variable that stores the data.
		
		return new ModelAndView(viewName,model);          //It return the view and data.
	}
}
