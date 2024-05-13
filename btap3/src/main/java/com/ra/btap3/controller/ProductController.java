package com.ra.btap3.controller;

import com.ra.btap3.model.entity.Category;
import com.ra.btap3.model.entity.Product;
import com.ra.btap3.model.entity.dto.ProductDto;
import com.ra.btap3.service.ICategory;
import com.ra.btap3.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProduct iProduct;
    @Autowired
    private ICategory iCategory;
    @GetMapping("/list")
    public String list(Model model){
        List<Product> productList = iProduct.findAll();
        model.addAttribute("productList",productList);
        return "product";
    }
    @GetMapping("/add")
    public String handleAdd(Model model){
        List<Category> categoryList = iCategory.findAll();
        model.addAttribute("categoryList",categoryList);
        return "product add";
    }
    @PostMapping("/add")
    public String add(@RequestParam("name") String name,@RequestParam("price") Double price,@RequestParam("stock") Integer stock,@RequestParam("categoryId") Integer categoryID,@RequestParam("status") Boolean status){
        ProductDto productDto = new ProductDto(null,name,price,stock,categoryID,status);
        iProduct.save(productDto);
        return "redirect:/product/list";
    }
    @GetMapping("/edit/{id}")
    public String handleEdit(@PathVariable("id") Integer id,Model model){
        Product product = iProduct.findById(id);
        model.addAttribute("product",product);
        List<Category> categoryList = iCategory.findAll();
        model.addAttribute("categoryList",categoryList);
        return "product edit";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer Id,@RequestParam("name") String name,@RequestParam("price") Double price,@RequestParam("stock") Integer stock,@RequestParam("categoryId") Integer categoryID,@RequestParam("status") Boolean status){
        ProductDto productDto = new ProductDto(Id,name,price,stock,categoryID,status);
        iProduct.save(productDto);
        return "redirect:/product/list";
    }
    @GetMapping("/change status/{id}")
    public String delete(@PathVariable("id") Integer id){
        iProduct.changeStatus(id);
        return "redirect:/product/list";
    }
}
