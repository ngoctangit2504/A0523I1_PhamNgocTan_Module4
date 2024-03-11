package com.furama.good.controller;

import com.furama.good.model.Product;
import com.furama.good.model.ProductDTO;
import com.furama.good.model.Status;
import com.furama.good.model.Type;
import com.furama.good.service.product.IProductService;
import com.furama.good.service.status.IStatusService;
import com.furama.good.service.type.ITypeService;
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
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ITypeService iTypeService;

    @Autowired
    private IStatusService iStatusService;
    @ModelAttribute("listType")
    public List<Type> showListType() {
        return iTypeService.showList();
    }
    @ModelAttribute("listStatus")
    public List<Status> showListStatus() {
        return iStatusService.showList();
    }

    @GetMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "3", required = false) int pageSize,
                                 Model model) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Product> pageProduct = iProductService.findAll(pageable);
        int size = pageProduct.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listPage.add(i);
        }
        model.addAttribute("page", listPage);
        return new ModelAndView("/list", "list", iProductService.findAll(pageable));
    }


    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "product", new ProductDTO());
    }


    @PostMapping("/add")
    public String addNewProduct(@Valid @ModelAttribute("product") ProductDTO product,
                                 BindingResult bindingResult) {
        // su dung de kiem tra loi doi voi custom validate
        // anonymous object
        // Garbage Collection -> cong cu don rac
        new ProductDTO().validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Product p = new Product();
        Type type = iTypeService.findById(product.getType());
        Status status = iStatusService.findById(product.getStatus());

        // chuyen doi du lieu tu DTO -> Entity
        BeanUtils.copyProperties(product, p);
        p.setType(type);
        p.setStatus(status);

        iProductService.addNewProduct(p);
        return "redirect:/";
    }




    @PostMapping("/{id}/showDelete")
    public String showDelete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", iProductService.findOne(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        iProductService.delete(id);
        return "redirect:/";
    }




    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Product product = iProductService.findOne(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product updatedProduct) {
        updatedProduct.setId(id);
        iProductService.updateProduct(updatedProduct);
        return "redirect:/";
    }

}
