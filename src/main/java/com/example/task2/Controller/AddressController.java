package com.example.task2.Controller;

import com.example.task2.Service.AddressService;
import com.example.task2.model.Employee;
import com.example.task2.model.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public List<EmployeeAddress> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Object> getAddressDetails(@PathVariable Long id) {
        EmployeeAddress employeeAddress = addressService.getAddressById(id);
        if (employeeAddress != null) {
            return new ResponseEntity<>(employeeAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Address Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addresses")
    public String createAddress(@RequestBody EmployeeAddress employeeAddress) {
        return addressService.createAddress(employeeAddress);
    }

    @PutMapping("/addresses/{id}")
    public String updateAddress(@PathVariable Long id, @RequestBody EmployeeAddress employeeAddress) {
        return addressService.updateAddress(id, employeeAddress);
    }

    @DeleteMapping("/addresses/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}
