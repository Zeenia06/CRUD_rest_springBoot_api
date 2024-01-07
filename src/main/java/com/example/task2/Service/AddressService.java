package com.example.task2.Service;

import com.example.task2.Repository.AddressRepository;
import com.example.task2.model.EmployeeAddress;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;



    public List<EmployeeAddress> getAllAddresses() {
        return addressRepository.findAll();
    }

    public EmployeeAddress getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public String createAddress(EmployeeAddress employeeAddress) {
        addressRepository.save(employeeAddress);
        return "Address is added";
    }

    public String updateAddress(Long id, EmployeeAddress employeeAddress) {
        Optional<EmployeeAddress> optionaladdress = addressRepository.findById(id);
        if (optionaladdress.isPresent()) {
            EmployeeAddress address = optionaladdress.get();
            address.setStreet(employeeAddress.getStreet());
            address.setCity(employeeAddress.getCity());
            address.setState(employeeAddress.getState());
            address.setZipCode(employeeAddress.getZipCode());
            addressRepository.save(address);
            return "Address is Updated";
        } else {
            return null;
        }
    }

    public String deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return "Address is delete";
    }
}
