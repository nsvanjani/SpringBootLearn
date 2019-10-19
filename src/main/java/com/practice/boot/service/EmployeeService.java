package com.practice.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.boot.dao.EmployeeCRUD;
import com.practice.boot.entity.Employee;
import com.practice.boot.request.SelectEmployeeRequest;
import com.practice.boot.response.SelectEmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	EmployeeCRUD empCrud;
	public void saveEmp(Employee e) {
		empCrud.saveEmployee(e);
	}
	public SelectEmployeeResponse getAllEmployees() {
		SelectEmployeeResponse response =  new SelectEmployeeResponse();
				response.setData(empCrud.getAllEmployees());
		return response;
	}
	public void saveAllEmployees(SelectEmployeeRequest request) {
		request.getData().stream().forEach(emp-> empCrud.saveEmployee(emp));
	}
}
