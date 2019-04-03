package com.employee.Employees.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employees.entity.Employee;
import com.employee.Employees.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public ArrayList<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	
	@GetMapping(value="/{employeeId}")
	@ApiOperation(value = "Find Employee by id",
    notes = "returns Employee Details") 
	public Employee getEmployeeById(@PathVariable Integer employeeId){
		return service.getEmployeeById(employeeId);
	}
	
	
	@PostMapping
	public void addNewEmployee(@RequestBody Employee employee) {
		service.addNewEmployee(employee);
	}
	
	@PutMapping
	public void updateEmployeeDetails(@RequestBody Employee employee) {
		service.updateEmployee(employee.getEmployeeId(), employee);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public void deleteEmployee(@PathVariable Integer employeeId) {
		service.deleteEmployee(employeeId);
	}

}
