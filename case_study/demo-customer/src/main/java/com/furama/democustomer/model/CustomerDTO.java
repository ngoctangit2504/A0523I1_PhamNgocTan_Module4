package com.furama.democustomer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;

public class CustomerDTO implements Validator {
    @NotBlank(message = "The employee name must not be empty")
    @Size(min = 3, message = "> 3 characters")
    @Size(max = 15, message = "< 15 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*(?:\\s[A-Z][a-zA-Z]*)*$", message = "only contain character")
//    @Pattern(regexp = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$", message = "only contain character")
    private String name;

    private Date birthday;
    private boolean gender;
    private int idCard;
    private int phone;
    @Size(min = 5, message = "email.min")
    private String email;
    private Long customerType;

    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, Date birthday, boolean gender, int idCard, int phone, String email, Long customerType, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Long customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        String email = customerDTO.getEmail();
        if ("".equals(email)) {
            errors.rejectValue("email", "", " Can not be empty");
        } else if (email.length() < 5) {
            errors.rejectValue("email", "email.min");
        }
    }
}
