package com.capg.springboot.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capg.springboot.entity.Employee;

@Service
public class EmployeeDaoImpl implements EmployeeDao {
	List<Employee> lst;
public EmployeeDaoImpl() {
	lst=new ArrayList<Employee>();
	lst.add(new Employee(101, "Haneesh", "Developer"));
	lst.add(new Employee(102,"Shruti","Designer"));
	lst.add(new Employee(103,"Abinash","Jr. Developer"));
	
}
	@Override
	public List<Employee> getEmployees() {
		return lst;
	}
	@Override
	public Employee getEmployeeById(long employeeId) {
		Employee emp=null;
		for(Employee e: lst) {
			if(e.getEmployeeId()==employeeId) {
				emp=e;
			}
		}
		return emp;
	}
	@Override
	public Employee addEmployee(Employee employee) {
		lst.add(employee);
		return employee;
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		lst.forEach(e-> {
			if(e.getEmployeeId()==employee.getEmployeeId()) {
				e.setEmployeeName(employee.getEmployeeName());
				e.setDesignation(employee.getDesignation());
			}
		});
		
		
		return employee;
	}
	@Override
	public void deleteEmployee(long employeeId) {
	lst=lst.stream().filter(e->e.getEmployeeId()!=employeeId)
	.collect(Collectors.toList());
		
	}

}