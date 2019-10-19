package com.practice.boot.response;

import java.util.List;

import com.practice.boot.entity.Employee;

public class SelectEmployeeResponse {

	List<Employee> data;

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}
	
}
