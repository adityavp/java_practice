package com.nuviso.employee;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private ArrayList<Employee> empArr = new ArrayList<>();
	
	@Autowired
	private EmployeeRepository empList;
	
	// GET
	public ArrayList<Employee> getAllEmployee() {
		// Empty List to re populate
		empArr.clear();
		for(Employee obj : empList.findAll())
			empArr.add(obj);
		return empArr;
	}
	
	// GET
	public Employee getEmployeeByEmpId(long employeeId) {
		return empList.findOne(employeeId);
	}
	
	// POST
	public String postNewEmployee(Employee newEmployee) {
		if(empList.save(newEmployee) != null)
			return "\n\nSuccess\n";
		else
			return "\n\nFailed\n";
	}
	
	// PUT
	public String putEmployee(Employee updateEmployee, long employeeId) {
		if(empList.save(updateEmployee) != null)
			return "\n\nSuccess\n";
		else
			return "\n\nFailed\n";
	}
	
	// DELETE
	public String deleteEmployeeByEmpId(long employeeId) {
		empList.delete(employeeId);
			return "\n\nSuccess\n";
	}
}
