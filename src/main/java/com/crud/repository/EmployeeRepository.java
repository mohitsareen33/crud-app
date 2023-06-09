package com.crud.repository;

import com.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface   EmployeeRepository extends JpaRepository<Employee, Long> {
}
