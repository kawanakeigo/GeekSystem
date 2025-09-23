package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RoleRepository;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    public AdminController(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

 

    @GetMapping
    public String listAdmins(Model model) {
        List<Admin> admins = adminRepository.findAll();
        model.addAttribute("admins", admins);
        return "admin-list";
    }
    
    
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("admin", new Admin());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin-form";
    }

    @PostMapping("/new")
    public String createAdmin(@ModelAttribute Admin admin) {
        Role role = roleRepository.findById(admin.getRole().getId()).orElse(null);
        admin.setRole(role);
        adminRepository.save(admin);
        return "redirect:/admins";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Admin admin = adminRepository.findById(id).orElse(null);
        model.addAttribute("admin", admin);
        model.addAttribute("roles", roleRepository.findAll());
        return "admin-form";
    }

    @PostMapping("/update")
    public String updateAdmin(@ModelAttribute Admin admin) {
        Role role = roleRepository.findById(admin.getRole().getId()).orElse(null);
        admin.setRole(role);
        adminRepository.save(admin);
        return "redirect:/admins";
    }
    
   
}