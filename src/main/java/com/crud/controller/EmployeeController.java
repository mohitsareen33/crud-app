package com.crud.controller;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //building create employee rest api
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    //building get all employee
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        list = employeeService.getAllEmployee();
        return ResponseEntity.ok(list);
    }

    //building get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    //building update employee api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    //building delete by id api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted succesfully");
    }
}
