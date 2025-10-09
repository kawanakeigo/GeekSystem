package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Makers;
import com.example.demo.repository.MakerRepository;

@Controller
@RequestMapping("/makers")
public class MakerController {
	private final MakerRepository makerRepository;
	public MakerController(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }
	
	@GetMapping
    public String listMakers(Model model) {
        model.addAttribute("makers", makerRepository.findAll());
        return "maker-list";
    }
	
	@GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("maker", new Makers());
        return "maker-form";
    }
	
    @PostMapping("/new")
    public String createMaker(@ModelAttribute Makers maker) {
        makerRepository.save(maker);
        return "redirect:/makers";
    }
    
    @GetMapping("{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Makers maker = makerRepository.findById(id).orElse(null);
        if (maker == null) return "redirect:/makers";
        model.addAttribute("maker", maker);
        return "maker-detail";
    }
    
    @PostMapping("/update")
    public String updateMaker(@ModelAttribute Makers maker) {
        makerRepository.save(maker);
        return "redirect:/makers";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteMaker(@PathVariable Long id) {
        makerRepository.deleteById(id);
        return "redirect:/makers";
    }
}
