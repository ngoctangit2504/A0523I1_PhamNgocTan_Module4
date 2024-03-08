package com.furama.resort.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;

public class EmployeeDTO implements Validator {
    @NotBlank(message = "The employee name must not be empty")
    @Size(min = 3, message = "> 3 characters")
    @Size(max = 15, message = "< 15 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*(?:\\\\s[A-Z][a-zA-Z]*)*$", message = "only contain character")
    private String name;

    private Date dateOfBirth;
    private int idCard;
    private int phone;

    @Size(min = 5, message = "email.min")
    private String email;
    private Long educationDegree;
    private Long position;
    private Long division;

    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, Date dateOfBirth, int idCard, int phone, String email, Long educationDegree, Long position, Long division, double salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Long getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(Long educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Long getDivision() {
        return division;
    }

    public void setDivision(Long division) {
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        String email = employeeDTO.getEmail();
        if ("".equals(email)) {
            errors.rejectValue("email", "", " Can not be empty");
        } else if (email.length() < 5) {
            errors.rejectValue("email", "email.min");
        }
    }
}
