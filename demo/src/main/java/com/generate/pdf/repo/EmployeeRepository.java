package com.generate.pdf.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.generate.pdf.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
			
}

