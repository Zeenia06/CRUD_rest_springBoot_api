package com.example.task2.Controller;

import com.example.task2.Service.AddressService;
import com.example.task2.Service.EmployeeService;
import com.example.task2.dto.EmployeeDetailsDTO;
import com.example.task2.model.Employee;
import com.example.task2.model.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{emp_id}")
    public ResponseEntity<Object> getEmployeeDetails(@PathVariable Long emp_id) {
        Employee employee = employeeService.getEmployeeById(emp_id);
        if (employee != null) {
            //EmployeeAddress employeeAddress = employeeService.getAddressForEmployee(employee);
            //return new ResponseEntity<>(new EmployeeDetailsDTO(employee, employeeAddress), HttpStatus.OK);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee NOt found", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{emp_id}")
    public Employee updateEmployee(@PathVariable Long emp_id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(emp_id, employee);
    }

    @DeleteMapping("/employees/{emp_id}")
    public String deleteEmployee(@PathVariable Long emp_id) {
        return employeeService.deleteEmployee(emp_id);
    }
}
