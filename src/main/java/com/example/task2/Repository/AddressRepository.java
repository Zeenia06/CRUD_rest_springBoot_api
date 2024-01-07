package com.example.task2.Repository;

import com.example.task2.model.Employee;
import com.example.task2.model.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<EmployeeAddress, Long> {
    EmployeeAddress findByEmployee(Employee employee);
}
