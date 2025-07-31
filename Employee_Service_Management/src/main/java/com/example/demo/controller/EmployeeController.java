package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return service.save(employee);
	}
	
	@GetMapping("/all")
	public List<Employee> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") Integer id) {
		return service.getByID(id);
	}
	
	@PutMapping("/{id}")
	public Employee update(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		return service.update(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
		
	}
	

}
