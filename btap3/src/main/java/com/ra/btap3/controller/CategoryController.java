package com.ra.btap3.controller;

import com.ra.btap3.model.entity.Category;
import com.ra.btap3.model.entity.Product;
import com.ra.btap3.model.entity.dto.ProductDto;
import com.ra.btap3.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategory iCategory;
    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("categoryList",iCategory.findAll());
        return "category";
    }
    @GetMapping("/add")
    public String handleAdd(Model model){
        return "category add";
    }
    @PostMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("status") Boolean status){
        Category category = new Category(null,name,status);
        iCategory.save(category);
        return "redirect:/category/list";
    }
    @GetMapping("/edit/{id}")
    public String handleEdit(@PathVariable("id") Integer id, Model model){
        Category category = iCategory.findById(id);
        System.out.println(category.getName());
        model.addAttribute("category",category);
        return "category edit";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer Id,@RequestParam("name") String name,@RequestParam("status") Boolean status){
        Category category = new Category(Id,name,status);
        iCategory.save(category);
        return "redirect:/category/list";
    }
    @GetMapping("/change status/{id}")
    public String delete(@PathVariable("id") Integer id){
        iCategory.changeStatus(id);
        return "redirect:/category/list";
    }
}
