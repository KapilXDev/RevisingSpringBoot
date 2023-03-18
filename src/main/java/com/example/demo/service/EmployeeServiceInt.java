package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Employee;

public interface EmployeeServiceInt {
	
	public Employee getEmployeeById(int id) throws Exception;
	public Employee addEmployee(Employee emp);
	public Employee deleteEmployee(Employee emp) throws Exception;
	public Employee updateEmployee(Employee emp);
	public List<Employee> getAll();

}
