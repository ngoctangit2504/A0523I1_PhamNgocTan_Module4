package com.furama.model.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeDTO implements Validator{
    @NotBlank(message = "The student's name must not be empty")
    @Size(min = 3, message = "> 3 characters")
    @Size(max = 10, message = "< 10 characters")
    @Pattern(regexp = "^[a-z ]*$", message = "only contain character")
    private String name;
    @Size(min = 5, message = "{email.min}")
    private String email;
    private int ;
    private Long codeGymClass;
    private Long codeGymClass;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        String email = employeeDTO.getEmail();
        if("".equals(email)) {
            errors.rejectValue("email","","Can not be empty");
        }else if(email.length() < 5) {
            errors.rejectValue("email","email.min");
        }
    }
}


//public class StudentDTO implements Validator {
//
//
//    public StudentDTO() {
//    }
//
//    public StudentDTO(String name, String email, Long codeGymClass) {
//        this.name = name;
//        this.email = email;
//        this.codeGymClass = codeGymClass;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Long getCodeGymClass() {
//        return codeGymClass;
//    }
//
//    public void setCodeGymClass(Long codeGymClass) {
//        this.codeGymClass = codeGymClass;
//    }

//
//    @Override
//    public void validate(Object target, Errors errors) {
//        StudentDTO studentDTO = (StudentDTO) target;
//        String email = studentDTO.getEmail();
//        if("".equals(email)) {
//            errors.rejectValue("email","","Can not be empty");
//        }else if(email.length() < 5) {
//            errors.rejectValue("email","email.min");
//        }
//    }
//}