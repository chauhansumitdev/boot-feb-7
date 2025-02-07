package com.example.usercrud.dto;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * MARK: UserDTO
 * DESC: A Data Transfer Object
 */
public class UserDTO {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long phoneNumber;
    private String country;
    private Integer pinCode;

    public UserDTO(UUID uuid, String firstName, String lastName, String email, String password, Long phoneNumber, String country, Integer pinCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.pinCode = pinCode;
        this.uuid = uuid;
    }

    public UUID getUuid(){
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
