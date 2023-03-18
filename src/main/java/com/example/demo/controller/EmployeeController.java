package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@RequestMapping("/Emp")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws Exception{
		
		Employee emp=empService.getEmployeeById(id);
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		Employee emp=empService.addEmployee(employee);
		
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllEmployees(){
		List<Employee> list=empService.getAll();
		
		return ResponseEntity.ok(list);
	}

}
