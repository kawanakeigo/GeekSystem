package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Makers;
import com.example.demo.service.MakerService;

@Controller
@RequestMapping("/makers")
public class MakerController {
	private final MakerService makerService;
	public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }
	
	@GetMapping
    public String listMakers(Model model) {
        model.addAttribute("makers", makerService.getAllMakers());
        return "maker-list";
    }
	
	@GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("maker", new Makers());
        return "maker-form";
    }
	
    @PostMapping("/new")
    public String createMaker(@ModelAttribute Makers maker) {
        makerService.createMaker(maker);
        return "redirect:/makers";
    }
    
    @GetMapping("{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Makers maker = makerService.getMakerById(id);
        if (maker == null) return "redirect:/makers";
        model.addAttribute("maker", maker);
        return "maker-detail";
    }
    
    @PostMapping("/update")
    public String updateMaker(@ModelAttribute Makers maker) {
        makerService.updateMaker(maker);
        return "redirect:/makers";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteMaker(@PathVariable Long id) {
        makerService.deleteMaker(id);
        return "redirect:/makers";
    }
}
