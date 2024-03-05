package com.example.customerphonevalidation.controller;

import com.example.customerphonevalidation.model.PhoneNumber;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index.html";
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index.html";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "result";
        }
    }
}
