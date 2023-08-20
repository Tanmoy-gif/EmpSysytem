package com.emp.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.system.entity.Employee;
import com.emp.system.repo.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
		return;
	}

	public List<Employee> getAllEmp() {
		List<Employee> emp=repo.findAll();
		return emp;
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp=repo.findById(id);
		return emp.get();
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
		return;
	}
	


}
