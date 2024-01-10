package com.example.tiente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TienTeController {
    @GetMapping("/")
    public String showFormConvert() {
        return "showFormConvert";
    }

    @PostMapping("/convert")
    public String showResult(@RequestParam double rate, @RequestParam double usd, Model model) {
        double vnd = rate * usd;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "result";
    }
}
