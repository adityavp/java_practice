package com.nuviso.employee;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empSer;
	
	@RequestMapping(method=RequestMethod.GET, value="/employees")
	public ArrayList<Employee> getAll() {
		return empSer.getAllEmployee();
	}
	
	@RequestMapping("/employees/{employeeId}")
	public Employee getOne(@PathVariable String employeeId) {
		return empSer.getEmployeeByEmpId(employeeId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public String createNew(@RequestBody Employee newEmployee) {
		// Validate received data
		if(newEmployee.getFirstName() == null || newEmployee.getLastName() == null || newEmployee.getEmailId() == null || newEmployee.getMobileNo() == null || newEmployee.getAddress() == null)
			return "\n\nSome required fields are empty\n";
		else if(empSer.isDuplicate(newEmployee.getEmailId()))
			return "\n\nEmailID Duplicate\n";
		else if(newEmployee.getMobileNo().length() != 10)
			return "\n\nMobile number should be 10 digits\n";
		else
			return empSer.postNewEmployee(newEmployee);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{employeeId}")
	public String updateExisting(@RequestBody Employee updateEmployee, @PathVariable String employeeId) {
		// Validate received data
		if(updateEmployee.getFirstName() == null || updateEmployee.getLastName() == null || updateEmployee.getEmailId() == null || updateEmployee.getMobileNo() == null || updateEmployee.getAddress() == null)				
			return "\n\nSome required fields are empty\n";
		else if(empSer.isDuplicate(updateEmployee.getEmailId()))
			return "\n\nEmailID Duplicate\n";
		else if(updateEmployee.getMobileNo().length() != 10)
			return "\n\nMobile number should be 10 digits\n";
		else
			return empSer.postNewEmployee(updateEmployee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{employeeId}")
	public String deleteOne(@PathVariable String employeeId) {
		return empSer.deleteEmployeeByEmpId(employeeId);
	}
	
}
