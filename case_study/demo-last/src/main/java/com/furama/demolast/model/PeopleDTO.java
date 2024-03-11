package com.furama.demolast.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;

public class PeopleDTO implements Validator {

    @NotBlank(message = "The employee name must not be empty")
    @Size(min = 3, message = "> 3 characters")
    @Size(max = 15, message = "< 15 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*(?:\\s[A-Z][a-zA-Z]*)*$", message = "only contain character")

    private String name;
    private Long gender;

    @NotBlank(message = "Phone number must not be blank")
    @Pattern(regexp="\\d{9}", message="Phone number must be exactly 9 digits")
    private String phone;
    @Size(min = 5, message = "email.min")
    private String email;
    private Long type;

    public PeopleDTO() {
    }

    public PeopleDTO(String name, Long gender, String phone, String email, Long type) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PeopleDTO peopleDTO = (PeopleDTO) target;
        String email = peopleDTO.getEmail();
        if ("".equals(email)) {
            errors.rejectValue("email", "", " Can not be empty");
        } else if (email.length() < 5) {
            errors.rejectValue("email", "email.min");
        }
    }
}
