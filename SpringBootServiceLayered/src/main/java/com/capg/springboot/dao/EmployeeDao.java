package com.capg.springboot.dao;

import java.util.List;

import com.capg.springboot.entity.Employee;

public interface EmployeeDao {
public List<Employee>  getEmployees();
public Employee getEmployeeById(long employeeId);
public Employee addEmployee(Employee employee);
public Employee updateEmployee(Employee employee);
public void deleteEmployee(long employeeId);
}

