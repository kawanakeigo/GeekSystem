package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list"; 
    }
    
    @GetMapping("/by-category")
    @ResponseBody
    public List<Products> getProductsByCategory(@RequestParam Long categoryId) {
    	
    	 List<Products> products = productService.findBySmallCategoryId(categoryId);
         if (!products.isEmpty()) return products;
    	
         products = productService.findByMiddleCategoryId(categoryId);
         if (!products.isEmpty()) return products;
    	
        return productService.findByLargeCategoryId(categoryId);
    }
}
