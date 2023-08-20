package com.emp.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.system.entity.Employee;
import com.emp.system.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller

public class EmpController {
	

	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String getHome(Model m) {
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		return"index";
	}
	
	@GetMapping("/addEmp")
	public String addEmp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String addEmp(@ModelAttribute Employee emp,HttpSession session) {
		System.out.println(emp);
		service.addEmp(emp);
		
		session.setAttribute("msg", "Employee Added Successfully ..");
		System.out.println("AddEmp");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id,Model m) {
		Employee e=service.getEmployeeById(id);
		m.addAttribute("emp",e);
		return "edit_emp";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp,HttpSession session) {
		System.out.println(emp);
		service.addEmp(emp);
		
		session.setAttribute("msg", "Employee Added Successfully ..");
		System.out.println("AddEmp");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		service.deleteEmp(id);
		return "redirect:/";
	}
	
	
	
	
	

}
