package com.example.springboot.controller;

import com.example.springboot.model.CodegymClass;
import com.example.springboot.model.Student;
import com.example.springboot.service.codegym_class.ICodegymClassService;
import com.example.springboot.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodegymClassService iCodegymClassService;

    @ModelAttribute("listClass")
    public List<CodegymClass> showListCodegymClass(){
        return iCodegymClassService.showList();
    }

    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("/list", "list",iStudentService.showList());
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/create","student",new Student());
    }

    @PostMapping("/add")
    public String addNewStudent(Student student){
        CodegymClass codegymClass = new CodegymClass();
        codegymClass.setName("Abc");
        student.setCodeGymClass(codegymClass);
        iStudentService.addNewStudent(student);
        return "redirect:/";
    }
}
