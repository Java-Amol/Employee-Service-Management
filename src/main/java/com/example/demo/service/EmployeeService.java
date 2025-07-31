package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	
	public Employee save(Employee employee);
	public List<Employee> getAll();
	public Employee getByID(Integer id);
	public Employee update(Integer id, Employee employee);
	public void delete(Integer id);

}
