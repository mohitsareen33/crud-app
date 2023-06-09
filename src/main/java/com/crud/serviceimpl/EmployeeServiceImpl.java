package com.crud.serviceimpl;

import com.crud.exception.ResourceNotFoundException;
import com.crud.model.Employee;
import com.crud.repository.EmployeeRepository;
import com.crud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = employeeRepository.findAll();

        return allEmployees;
        // return employeeRepository.findAll();

    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }

//        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee", "id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);
    }
}
