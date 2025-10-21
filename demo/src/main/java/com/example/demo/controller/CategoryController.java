package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.LargeCategoryDTO;
import com.example.demo.DTO.MiddleCategoryDTO;
import com.example.demo.DTO.SmallCategoryDTO;
import com.example.demo.service.CategoryService;


@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    
    public CategoryController(
    		CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }
    
    @GetMapping("/large")
    public String listLargeCategory(
    	Model model
    ) {
        List<LargeCategoryDTO> largeCategories = categoryService.getAllLargeCategories();
        model.addAttribute("largeCategories", largeCategories);
        return "large-categories-list"; 
    }
    
    @GetMapping("/large/{id}")
    public String detailLargeCategory(
    	@PathVariable Long id, Model model
    ) {
        LargeCategoryDTO large = categoryService.getLargeCategoryById(id);
        if (large == null) return "redirect:/categories/large";

        List<MiddleCategoryDTO> middleList =categoryService.getMiddleCategoriesByLargeId(id);

        model.addAttribute("largeCategory", large);
        model.addAttribute("middleCategories", middleList);
        return "large-categories-detail"; 
    }
    
    @GetMapping("/middle/{id}")
    public String detailMiddleCategory(
    	@PathVariable Long id, Model model
    ) {
    	MiddleCategoryDTO middle = categoryService.getMiddleCategoryById(id);
        if (middle == null) return "redirect:/categories/large";

        List<SmallCategoryDTO> smallList = categoryService.getSmallCategoriesByMiddleId(id);

        model.addAttribute("middleCategory", middle);
        model.addAttribute("smallCategories", smallList);
        return "middle-categories-detail";
    }
    
    @GetMapping("/small/{id}")
    public String detailSmallCategory(
    	@PathVariable Long id, Model model
    ) {
        SmallCategoryDTO small = categoryService.getSmallCategoryById(id);
        if (small == null) return "redirect:/categories/large";

        model.addAttribute("smallCategory", small);
        return "small-categories-detail";
    }
    
    @GetMapping("/children")
    @ResponseBody
    public List<CategoryDTO> getChildCategories(
    	@RequestParam("parentId") Long parentId
    ) {
        return categoryService.getChildCategories(parentId);
    }
}
