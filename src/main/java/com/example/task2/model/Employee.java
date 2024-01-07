package com.example.task2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;


    @Column(name = "EmailId", nullable = false)
    private String emailId;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private EmployeeAddress employeeAddress;

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public Long getEmp_id() { return emp_id; }
    public void setEmp_id(Long emp_id) {this.emp_id = emp_id;}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) { this.firstName = firstName;}

    public String getLastName() { return lastName;}
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() { return emailId;}
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public EmployeeAddress getEmployeeAddress() { return employeeAddress;}
    public void setEmployeeAddress(EmployeeAddress employeeAddress) { this.employeeAddress = employeeAddress;}

    @Override
    public String toString() {
        return "Employee [emp_id=" + emp_id + ", firstName = " + firstName + ", lastName = " + lastName + ", emailId = " + emailId + "]";
    }
}
