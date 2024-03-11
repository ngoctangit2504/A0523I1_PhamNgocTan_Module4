package com.furama.good.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {

    @NotBlank(message = "The employee name must not be empty")
    @Size(min = 5, message = "> 5 characters")
    @Size(max = 50, message = "< 50 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*(?:\\s[A-Z][a-zA-Z]*)*$", message = "only contain character")
    private String name;


    @NotBlank(message = "Phone number must not be blank")
//    @Pattern(regexp="\\d{9}", message="Phone number must be exactly 9 digits")
    private String price;
    private Long type;
    private Long status;

    public ProductDTO() {
    }

    public ProductDTO(String name, String price, Long type, Long status) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
    }
}
