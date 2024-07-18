package com.example.springbootf.controller;
import exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootf.entity.employee;
import com.example.springbootf.repo.EmployeeRepository;
import java.util.List;
@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    //REST api
    @PostMapping
    public employee createEmployee(@RequestBody employee employee) {
        return employeeRepository.save(employee);
    }
    @GetMapping("{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable long id) {
        employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id " + id)
        );
        return ResponseEntity.ok(employee);

    }
    @PutMapping("{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable long id, @RequestBody employee employee) {
        employee employee1 = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id " + id)
        );
        employee1.setEmp_first_name(employee.getEmp_first_name());
        employee1.setEmp_last_name(employee.getEmp_last_name());
        employee1.setEmp_email(employee.getEmp_email());
        employeeRepository.save(employee1);
        return ResponseEntity.ok(employee1);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id " + id)
        );
        employeeRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllEmployee() {

        employeeRepository.deleteAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
