package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.LargeCategory;
import com.example.demo.entity.Middle_Categories;
import com.example.demo.entity.Small_Categories;
import com.example.demo.repository.LargeCategoryRepository;
import com.example.demo.repository.Middle_CategoriesRepository;
import com.example.demo.repository.Small_CategoriesRepository;



@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final LargeCategoryRepository largeRepo;
    private final Middle_CategoriesRepository middleRepo;
    private final Small_CategoriesRepository smallRepo;
    
    public CategoryController(
    		LargeCategoryRepository largeRepo,
    		Middle_CategoriesRepository middleRepo,
    		Small_CategoriesRepository smallRepo
    		) {
        this.largeRepo = largeRepo;
        this.middleRepo = middleRepo;
        this.smallRepo = smallRepo;
    }
    
    @GetMapping("/large")
    public String listLargeCategory(Model model) {
        List<LargeCategory> largeCategories = largeRepo.findAll();
        model.addAttribute("largeCategories", largeCategories);
        return "large-categories-list"; 
    }
    
    @GetMapping("/large/{id}")
    public String detailLargeCategory(@PathVariable Long id, Model model) {
        LargeCategory large = largeRepo.findById(id).orElse(null);
        if (large == null) return "redirect:/categories/large";

        List<Middle_Categories> middleList = middleRepo.findAll()
                .stream()
                .filter(m -> m.getLargeCategoriesId().equals(id))
                .toList();

        model.addAttribute("largeCategory", large);
        model.addAttribute("middleCategories", middleList);
        return "large-categories-detail"; 
    }
    
    @GetMapping("/middle/{id}")
    public String detailMiddleCategory(@PathVariable Long id, Model model) {
        Middle_Categories middle = middleRepo.findById(id).orElse(null);
        if (middle == null) return "redirect:/categories/large";

        List<Small_Categories> smallList = smallRepo.findAll()
                .stream()
                .filter(s -> s.getMiddleCategoriesId().equals(id))
                .toList();

        model.addAttribute("middleCategory", middle);
        model.addAttribute("smallCategories", smallList);
        return "middle-categories-detail";
    }
    
    @GetMapping("/small/{id}")
    public String detailSmallCategory(@PathVariable Long id, Model model) {
        Small_Categories small = smallRepo.findById(id).orElse(null);
        if (small == null) return "redirect:/categories/large";

        model.addAttribute("smallCategory", small);
        return "small-categories-detail";
    }
    
    @GetMapping("/children")
    @ResponseBody
    public List<?> getChildCategories(@RequestParam("parentId")Long parentId){
    	if(middleRepo.existsByLargeCategoriesId(parentId)) {
    		return middleRepo.findByLargeCategoriesId(parentId);
    	}
    	
    	if(smallRepo.existsByMiddleCategoriesId(parentId)) {
    		return smallRepo.findByMiddleCategoriesId(parentId);
    	}
    	return List.of();
    }
}
