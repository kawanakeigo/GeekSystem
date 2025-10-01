package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import com.example.demo.form.AdminForm;
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
        model.addAttribute("adminForm", new AdminForm());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin-form";
    }
    @PostMapping("/new")
    public String createAdmin(@Valid @ModelAttribute ("adominForm")  AdminForm form) {
        Admin admin = new Admin();
        admin.setName(form.getName());
        admin.setEmail(form.getEmail());
        admin.setPassword(form.getPassword());
        Role role = roleRepository.findById(form.getRoleId()).orElse(null);
        admin.setRole(role);
        adminRepository.save(admin);
        return "redirect:/admins";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return "redirect:/admins";
        }
        AdminForm form = new AdminForm();
        form.setId(admin.getId());
        form.setName(admin.getName());
        form.setEmail(admin.getEmail());
        form.setRoleId(admin.getRole().getId());
        model.addAttribute("adminForm", form);
        model.addAttribute("roles", roleRepository.findAll());
        return "admin-form";
    }
    @PostMapping("/update")
    public String updateAdmin(@ModelAttribute AdminForm form) {
        Admin admin = adminRepository.findById(form.getId()).orElse(null);
        if (admin == null) {
            return "redirect:/admins"; 
        }
        admin.setName(form.getName());
        admin.setEmail(form.getEmail());
        if (form.getPassword() != null && !form.getPassword().isEmpty()) {
            admin.setPassword(form.getPassword());
        }
        Role role = roleRepository.findById(form.getRoleId()).orElse(null);
        admin.setRole(role);
        adminRepository.save(admin);
        return "redirect:/admins";
    }
}