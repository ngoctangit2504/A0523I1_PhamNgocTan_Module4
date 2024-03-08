package com.furama.democustomer.controller;

import com.furama.democustomer.model.Customer;
import com.furama.democustomer.model.CustomerDTO;
import com.furama.democustomer.model.CustomerType;
import com.furama.democustomer.service.customer.ICustomerSrvice;
import com.furama.democustomer.service.customerType.ICustomerTypeService;
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
public class CustomerController {
    @Autowired
    private ICustomerSrvice iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @ModelAttribute("listCustomerType")
    public List<CustomerType> showListCustomerType() {
        return iCustomerTypeService.showList();
    }

    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "3", required = false) int pageSize,
                                 Model model) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Customer> pageCustomer = iCustomerService.findAll(pageable);
        int size = pageCustomer.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }
        model.addAttribute("page", listPage);
        return new ModelAndView("/list", "list", iCustomerService.findAll(pageable));
    }


    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "customer", new CustomerDTO());
    }


    @PostMapping("/add")
    public String addNewCustomer(@Valid @ModelAttribute("customer") CustomerDTO customer,
                                 BindingResult bindingResult) {
        // su dung de kiem tra loi doi voi custom validate
        // anonymous object
        // Garbage Collection -> cong cu don rac
        new CustomerDTO().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Customer c = new Customer();
        CustomerType customerType = iCustomerTypeService.findById(customer.getCustomerType());

        // chuyen doi du lieu tu DTO -> Entity
        BeanUtils.copyProperties(customer, c);
        c.setCustomerType(customerType);

        iCustomerService.addNewCustomer(c);
        return "redirect:/";
    }




    @PostMapping("/{id}/showDelete")
    public String showDelete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", iCustomerService.findOne(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        iCustomerService.delete(id);
        return "redirect:/";
    }

}

