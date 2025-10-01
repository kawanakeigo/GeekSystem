package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.StoreRepository;

@Controller
@RequestMapping("/stores")
public class StoreController {
    private final StoreRepository storeRepository;
    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    
    @GetMapping
    public String getAllStores(Model model) {
        model.addAttribute("stores", storeRepository.findAll());
        return "store-list"; 
    }
}
