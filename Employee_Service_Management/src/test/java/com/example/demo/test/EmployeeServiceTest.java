package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl service;
	
	@Mock
	private EmployeeRepository repo;
	
	@Test
	public void testSaveEmployee() {
		Employee emp = new Employee(01, "amol", "IT", 750000);
		when(repo.save(emp)).thenReturn(emp);
		
		Employee result = service.save(emp);
		assertEquals("amol", result.getName());
		
	}
}
