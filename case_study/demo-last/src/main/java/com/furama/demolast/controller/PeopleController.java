package com.furama.demolast.controller;

import com.furama.demolast.model.Gender;
import com.furama.demolast.model.People;
import com.furama.demolast.model.PeopleDTO;
import com.furama.demolast.model.Type;
import com.furama.demolast.service.gender.IGenderService;
import com.furama.demolast.service.people.IPeopleService;
import com.furama.demolast.service.type.ITypeService;
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

@Controller
@RequestMapping("")
public class PeopleController {
    @Autowired
    private IPeopleService iPeopleService;

    @Autowired
    private ITypeService iTypeService;

    @Autowired
    private IGenderService iGenderService;
    @ModelAttribute("listType")
    public List<Type> showListType() {
        return iTypeService.showList();
    }
    @ModelAttribute("listGender")
    public List<Gender> showListGender() {
        return iGenderService.showList();
    }

    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "3", required = false) int pageSize,
                                 Model model) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<People> pagePeople = iPeopleService.findAll(pageable);
        int size = pagePeople.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }
        model.addAttribute("page", listPage);
        return new ModelAndView("/list", "list", iPeopleService.findAll(pageable));
    }


    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "people", new PeopleDTO());
    }


    @PostMapping("/add")
    public String addNewCustomer(@Valid @ModelAttribute("people") PeopleDTO people,
                                 BindingResult bindingResult) {
        // su dung de kiem tra loi doi voi custom validate
        // anonymous object
        // Garbage Collection -> cong cu don rac
        new PeopleDTO().validate(people, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        People p = new People();
        Type type = iTypeService.findById(people.getType());
        Gender gender = iGenderService.findById(people.getGender());

        // chuyen doi du lieu tu DTO -> Entity
        BeanUtils.copyProperties(people, p);
        p.setType(type);
        p.setGender(gender);

        iPeopleService.addNewPeople(p);
        return "redirect:/";
    }




    @PostMapping("/{id}/showDelete")
    public String showDelete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("people", iPeopleService.findOne(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        iPeopleService.delete(id);
        return "redirect:/";
    }




    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        People people = iPeopleService.findOne(id);
        model.addAttribute("people", people);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updatePeople(@PathVariable("id") Long id, @ModelAttribute("people") People updatedPeople) {
        updatedPeople.setId(id);
        iPeopleService.updatePeople(updatedPeople);
        return "redirect:/";
    }

}
