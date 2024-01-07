package com.example.task2.Service;

import com.example.task2.Repository.AddressRepository;
import com.example.task2.Repository.EmployeeRepository;
import com.example.task2.model.Employee;
import com.example.task2.model.EmployeeAddress;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;



    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long emp_id) {
        return employeeRepository.findById(emp_id).orElse(null);
    }

    public EmployeeAddress getAddressForEmployee(Employee employee) {
        if (employee != null) {
            return addressRepository.findByEmployee(employee);
        }
        return null;
    }

    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee Information Added";
    }

    public Employee updateEmployee(Long emp_id, Employee updateEmployee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(emp_id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updateEmployee.getFirstName());
            employee.setLastName(updateEmployee.getLastName());
            employee.setEmailId(updateEmployee.getEmailId());
            return employeeRepository.save(employee);
        } else {
            return  null; }
    }

    public String deleteEmployee(Long emp_id) {
        employeeRepository.deleteById(emp_id);
        return "Employee information deleted";
    }
}
