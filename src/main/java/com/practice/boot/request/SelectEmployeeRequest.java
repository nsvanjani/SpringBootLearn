package com.practice.boot.request;

import java.util.List;

import com.practice.boot.entity.Employee;

public class SelectEmployeeRequest {
List<Employee> data;

public List<Employee> getData() {
	return data;
}

public void setData(List<Employee> data) {
	this.data = data;
}

}
