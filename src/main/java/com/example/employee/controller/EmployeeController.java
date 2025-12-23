package com.example.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}

	@GetMapping
	public List<Employee> getAll() {
		return service.getEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
		return service.updateEmpolyee(id, employee);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		boolean deleted=service.deleteEmployeeByID(id);
		return deleted? "Employee Deleted Successfully!":"Employee Not Found";
	}
}
