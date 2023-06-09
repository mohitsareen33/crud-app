package com.crud.service;

import com.crud.model.Employee;

import java.util.List;

public interface EmployeeService {

        Employee saveEmployee(Employee emp);

        List<Employee> getAllEmployee();

        Employee getEmployeeById(long id);

        Employee updateEmployee(long id, Employee employee);

        void deleteEmployee(long id);
}
