package com.nuviso.employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	public Employee findByEmailId(String emailId);
}
