package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee getByID(Integer id) {
		return empRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}

	@Override
	public Employee update(Integer id, Employee employee) {
		Employee existing = getByID(id);
		existing.setName(employee.getName());
		existing.setDepartment(employee.getDepartment());
		existing.setSalary(employee.getSalary());

		return empRepo.save(existing);
	}

	@Override
	public void delete(Integer id) {
		empRepo.deleteById(id);

	}

}
