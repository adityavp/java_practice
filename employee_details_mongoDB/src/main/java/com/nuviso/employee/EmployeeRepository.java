package com.nuviso.employee;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	public Employee findByEmailId(String emailId);
}
