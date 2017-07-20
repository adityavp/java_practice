package com.nuviso.employee;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private ArrayList<Employee> empArr = new ArrayList<>();
	
	@Autowired
	private EmployeeRepository empList;
	
	// is Duplicate?
		public boolean isDuplicate(String emailId) {
			if(empList.findByEmailId(emailId) != null)
				return true;
			else 
				return false;
		}
		
	// GET
	public ArrayList<Employee> getAllEmployee() {
		// Empty List to re populate
		empArr.clear();
		for(Employee obj : empList.findAll())
			empArr.add(obj);
		return empArr;
	}
	
	// GET
	public Employee getEmployeeByEmpId(String employeeId) {
		return empList.findOne(employeeId);
	}
	
	// POST
	public String postNewEmployee(Employee newEmployee) {
		if(empList.insert(newEmployee) != null) 
			return "\n\nSuccess\n";
		else
			return "\n\nFailed\n";
	}
	
	// PUT
	public String putEmployee(Employee updateEmployee, String employeeId) {
		if(empList.insert(updateEmployee) != null)
			return "\n\nSuccess\n";
		else
			return "\n\nFailed\n";
	}
	
	// DELETE
	public String deleteEmployeeByEmpId(String employeeId) {
		empList.delete(employeeId);
			return "\n\nSuccess\n";
	}
}
