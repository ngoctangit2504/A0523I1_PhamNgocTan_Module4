package com.furama.resort.controller;

import com.furama.resort.model.*;
import com.furama.resort.service.division.IDivisionService;
import com.furama.resort.service.educationDegree.IEducationDegreeService;
import com.furama.resort.service.employee.IEmployeeService;
import com.furama.resort.service.position.IPositionService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<EducationDegree> showListEducationEdgree() {
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
        model.addAttribute("page", listPage);
        return new ModelAndView("/list", "list", iEmployeeService.findAll(pageable));
    }


    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "employee", new EmployeeDTO());
    }


    @PostMapping("/add")
    public String addNewEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employee,
                                 BindingResult bindingResult) {
        // su dung de kiem tra loi doi voi custom validate
        // anonymous object
        // Garbage Collection -> cong cu don rac
        new EmployeeDTO().validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Employee e = new Employee();
        EducationDegree educationDegree = iEducationDegreeService.findById(employee.getEducationDegree());
        Division division = iDivisionService.findById(employee.getDivision());
        Position position = iPositionService.findById(employee.getPosition());

        // chuyen doi du lieu tu DTO -> Entity
        BeanUtils.copyProperties(employee, e);

        e.setEducationDegree(educationDegree);
        e.setDivision(division);
        e.setPosition(position);

        iEmployeeService.addNewEmployee(e);
        return "redirect:/";
    }




    @PostMapping("/{id}/showDelete")
    public String showDelete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", iEmployeeService.findOne(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        iEmployeeService.delete(id);
        return "redirect:/";
    }

}
