package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repo;

	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
	}

	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}

	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Employee updateEmpolyee(Long id, Employee updated) {
		return repo.findById(id).map(emp -> {
			emp.setName(updated.getName());
			emp.setAge(updated.getAge());
			emp.setDepartment(updated.getDepartment());
			return repo.save(emp);
		}).orElse(null);
	}

	public boolean deleteEmployeeByID(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

}