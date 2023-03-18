package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dto.Employee;

@SpringBootTest
public class EmployeeServiceImplTest {
	
	@MockBean
	EmployeeRepo repo;
	@Autowired
	EmployeeServiceImpl service;
	
	static Employee emp;
	static List<Employee> list;
	
	@BeforeAll
	static void setUp() {
		emp=new Employee(1, "empName", "empDept");
		list=new ArrayList<>();
		list.add(new Employee(1, "empName1", "empDept1"));
		list.add(new Employee(2, "empName2", "empDept3"));
		list.add(new Employee(2, "empName2", "empDept3"));
		
	}
	
	
	// Assertions.assertEquals(actual,expected);
	
	
	@Test
	void TestGetEmployeeById() throws Exception{
		
		
		
		Optional<Employee> emp1=Optional.of(emp);
		Mockito.when(repo.findById(1)).thenReturn(emp1);
		assertThat(service.getEmployeeById(1)).isEqualTo(emp);
		
		//Assertions.assertThrows(Exception.class, service.getEmployeeById(2));
	
	}
	
	@Test
	void testResourceNotFoundException() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, ()->
		{
			service.getEmployeeById(2);
		}, "Exception Matching");
		
	}
	
	@Test
	void testAddEmployee() {
		
		
		Mockito.when(repo.save(emp)).thenReturn(emp);
		assertThat(service.addEmployee(emp)).isEqualTo(emp);
	}
	
	
	@Test
	void testGetAll() {
		
		Mockito.when(repo.findAll()).thenReturn(list);
		assertThat(service.getAll()).isEqualTo(list);
		
	}
	
	@Test
	void testDeleteEmploye() throws Exception{
		Mockito.when(repo.save(emp)).thenReturn(emp);
		//Mockito.when(repo.findById(emp.getEmpId()).get()).thenReturn(emp);
		assertThat(service.deleteEmployee(emp)).isEqualTo(emp);
		
	}
	
	@Test
	void testUpdateEmployee() {
		Mockito.when(repo.save(emp)).thenReturn(emp);
		assertThat(service.addEmployee(emp)).isEqualTo(emp);
	}
	
	@AfterAll
	static void clearUp() {
		
		emp=null;
		list=null;
	}

}
