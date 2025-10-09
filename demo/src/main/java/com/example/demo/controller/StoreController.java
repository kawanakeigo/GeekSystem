package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;

@Controller
@RequestMapping("/stores")
public class StoreController {
    private final StoreRepository storeRepository;
    private final StoreService storeService;
    
    public StoreController(StoreRepository storeRepository ,StoreService storeService) {
        this.storeRepository = storeRepository;
        this.storeService = storeService;
    }
    
    @GetMapping
    public String getAllStores(Model model) {
        model.addAttribute("stores", storeRepository.findAll());
        return "store-list"; 
    }
    
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Store store = storeService.findById(id);
        if (store == null) {
            return "redirect:/stores";
        }
        model.addAttribute("store", store);
        return "stores-detail";
    }
    
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Store store = storeService.findById(id);
        if (store == null) {
            return "redirect:/stores";
        }
        model.addAttribute("store", store);
        return "stores-edit";
    }
    
    @PostMapping("/{id}/edit")
    public String updateStore(@PathVariable Long id, @ModelAttribute Store store) {
        store.setId(id); 
        storeService.save(store);
        return "redirect:/stores/" + id;
    }
    
    @PostMapping("/{id}/delete")
    public String deleteStore(@PathVariable Long id) {
        storeService.deleteById(id);
        return "redirect:/stores";
    }
}
