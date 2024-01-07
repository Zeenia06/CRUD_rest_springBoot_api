package com.example.task2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StreetNo")
    private Long street;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "ZipCode")
    private Long zipCode;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Employee employee;

    public EmployeeAddress(Long street, String city, String state, Long zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStreet() { return street;}
    public void setStreet(Long street) { this.street = street;}

    public String getCity() { return city;}
    public void  setCity(String city) {this.city = city;}

    public String getState() { return state;}
    public void setState(String state) { this.state = state;}

    public Long getZipCode() { return zipCode;}
    public void setZipCode(Long zipCode) { this.zipCode = zipCode; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "Address [id = " + id + ", City = " + city + ", State = " + state + ", street = " + street + ", zipCode = " + zipCode + "]";
    }
}
