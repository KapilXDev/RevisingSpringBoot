package com.example.demo.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInt{
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s= ()->new ResourceNotFoundException("Employee Not Found.");
		Employee e=repo.findById(id).orElseThrow(s);
		return e;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		repo.save(emp);
		return emp;
	}

	@Override
	public Employee deleteEmployee(Employee emp) throws Exception{
		// TODO Auto-generated method stub
		repo.delete(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> list=repo.findAll();
		return list;
	}

}
