package com.example.task2.dto;

import com.example.task2.model.Employee;
import com.example.task2.model.EmployeeAddress;

public class EmployeeDetailsDTO {
    private Employee employee;
    private EmployeeAddress employeeAddress;

    public EmployeeDetailsDTO(Employee employee, EmployeeAddress employeeAddress) {
        this.employee = employee;
        this.employeeAddress = employeeAddress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeAddress getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddress employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
