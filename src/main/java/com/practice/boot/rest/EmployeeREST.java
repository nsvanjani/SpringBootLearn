package com.practice.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.boot.entity.Employee;
import com.practice.boot.request.SelectEmployeeRequest;
import com.practice.boot.response.SelectEmployeeResponse;
import com.practice.boot.service.EmployeeService;

@RestController
public class EmployeeREST {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(path = "/saveEmployee", 
			produces = MediaType.TEXT_HTML_VALUE)
	public String saveEmployee() {
		Employee e = new Employee();
		e.setEmail("nsvanjani@gmail.com");
		e.setId(111);
		e.setName("Navin Vanjani");

		employeeService.saveEmp(e);
		return "Done";
	}
	
	@GetMapping(path = "/getEmployee", 
			produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE })
	public SelectEmployeeResponse getAllEMployees() {
		return employeeService.getAllEmployees();
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE , path="/saveEmployees" )
	public String addEmployees(@RequestBody SelectEmployeeRequest request) {
		employeeService.saveAllEmployees(request);
		return "Done!";
	}
	
}
