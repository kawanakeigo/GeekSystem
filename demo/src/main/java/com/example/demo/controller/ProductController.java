package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Products;
import com.example.demo.repository.ProductRepository;

@Controller
@RequestMapping("/products")

public class ProductController {
    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Products> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByLargeCategoryId(categoryId);
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product-list"; 
    }
    
    @GetMapping("/by-category")
    @ResponseBody
    public List<Products> getProductsByCategory(@RequestParam Long categoryId) {
    	
    	 List<Products> products = productRepository.findBySmallCategoryId(categoryId);
         if (!products.isEmpty()) return products;
    	
         products = productRepository.findByMiddleCategoryId(categoryId);
         if (!products.isEmpty()) return products;
         
    	
        return productRepository.findByLargeCategoryId(categoryId);
    }
}
