package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.MakerForm;
import com.example.demo.service.MakerService;

@Controller
@RequestMapping("/makers")
public class MakerController {
	private final MakerService makerService;
	public MakerController(
		MakerService makerService
	) {
        this.makerService = makerService;
    }
	
	@GetMapping
    public String listMakers(
    	Model model
    ) {
        model.addAttribute("makers", makerService.getAllMakers());
        return "maker-list";
    }
	
	@GetMapping("/new")
    public String showCreateForm(
    	Model model
    ) {
        model.addAttribute("makerForm", new MakerForm());
        return "maker-form";
    }
	
    @PostMapping("/new")
    public String createMaker(
    	@ModelAttribute MakerForm form
    ) {
        makerService.createMaker(form);
        return "redirect:/makers";
    }
    
    @GetMapping("{id}")
    public String showEditForm(
    	@PathVariable Long id, Model model
    ) {
        MakerForm form = makerService.getMakerFormById(id);
        if (form == null) return "redirect:/makers";
        model.addAttribute("makerForm", form);
        return "maker-detail";
    }
    
    @PostMapping("/update")
    public String updateMaker(
    	@ModelAttribute MakerForm form
    ) {
        makerService.updateMaker(form);
        return "redirect:/makers";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteMaker(
    	@PathVariable Long id
    ) {
        makerService.deleteMaker(id);
        return "redirect:/makers";
    }
}
