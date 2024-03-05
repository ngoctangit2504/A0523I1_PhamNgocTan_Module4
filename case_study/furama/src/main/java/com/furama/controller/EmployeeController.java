package com.furama.controller;

import com.furama.model.employee.Division;
import com.furama.model.employee.EducationDegree;
import com.furama.model.employee.Employee;
import com.furama.model.employee.Position;
import com.furama.service.employee.impl.IDivisionService;
import com.furama.service.employee.impl.IEducationDegreeService;
import com.furama.service.employee.impl.IEmployeeService;
import com.furama.service.employee.impl.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IPositionService iPositionService;


    @ModelAttribute("listEducationDegree")
    public List<EducationDegree> showListEducationDegree() {
        return iEducationDegreeService.showList();
    }
    @ModelAttribute("listDivision")
    public List<Division> showListDivision() {
        return iDivisionService.showList();
    }
    @ModelAttribute("listPosition")
    public List<Position> showListPosition() {
        return iPositionService.showList();
    }

    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "3", required = false) int pageSize,
                                 Model model) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Employee> pageEmployee = iEmployeeService.findAll(pageable);
        int size = pageEmployee.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }
        model.addAttribute("pages", listPage);
        return new ModelAndView("/list", "list", iEmployeeService.findAll(pageable));
    }


    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/error_page";
    }



    //    @GetMapping("/show-form-create")
//    public ModelAndView showFormCreate() {
//        return new ModelAndView("/create", "student", new StudentDTO());
//    }

}




//@Controller
//@RequestMapping("")
//public class StudentController {


//
//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "/error_page";
//    }
//
//
//
//    @PostMapping("/add")
//    public String addNewStudent(@Valid @ModelAttribute("student") StudentDTO student,
//                                BindingResult bindingResult) throws NotFoundClassException {
//        // Sử dụng để kiểm tra lỗi đối với custom validate
//        // anonymous object
//        // Garbage Collection -> công cụ dọn rác
//        new StudentDTO().validate(student, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "/create";
//        }
//        Student s = new Student();
//        CodegymClass codegymClass = iCodegymClassService.findById(student.getCodeGymClass());
//        // Cố tình tạo exception
//        if (codegymClass == null) {
//            throw new NotFoundClassException();
//        }
//        // Chuyển đổi dữ liệu từ DTO -> Entity
//        BeanUtils.copyProperties(student, s);
//        s.setCodeGymClass(codegymClass);
//        iStudentService.addNewStudent(s);
//        return "redirect:/";
//    }
//}