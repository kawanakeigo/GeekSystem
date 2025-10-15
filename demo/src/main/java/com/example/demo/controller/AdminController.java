package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.AdminDTO;
import com.example.demo.form.AdminForm;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(
    		AdminService adminService) {
        this.adminService = adminService;
    }

    // 一覧
    @GetMapping
    public String listAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admin-list";
    }

    // 詳細
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("admin", adminService.getAdmin(id));
        return "admins-detail";
    }

    // 新規作成フォーム
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("adminForm", new AdminForm());
        model.addAttribute("roles", adminService.getAllRoll());
        model.addAttribute("stores", adminService.getAllStores());
        model.addAttribute("authorities", adminService.getAllAuthorities());
        return "admin-form";
    }

    // 新規作成処理
    @PostMapping("/new")
    public String createAdmin(@Valid @ModelAttribute("adminForm") AdminForm form, BindingResult result,Model model) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("roles", adminService.getAllRoll());
            model.addAttribute("stores", adminService.getAllStores());
            model.addAttribute("authorities", adminService.getAllAuthorities());
    		return "admin-form";
    	}
    	
        adminService.create(form);
        return "redirect:/admins";
    }

    // 編集フォーム
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        AdminDTO adminDto = adminService.getAdmin(id);
        if (adminDto == null) {
            return "redirect:/admins";
        }
        AdminForm form = adminService.convertToForm(adminDto);
        

        model.addAttribute("adminForm", form);
        model.addAttribute("roles", adminService.getAllRoll());
        model.addAttribute("stores", adminService.getAllStores());
        model.addAttribute("authorities", adminService.getAllAuthorities());
        return "admin-form";
    }

    // 編集処理
    @PostMapping("/{id}/edit")
    public String updateAdmin(@PathVariable Long id, @Valid @ModelAttribute("adminForm") AdminForm form,BindingResult result,Model model) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("roles", adminService.getAllRoll());
            model.addAttribute("stores", adminService.getAllStores());
            model.addAttribute("authorities", adminService.getAllAuthorities());
    		return "admin-form";
    	}
    	
        adminService.update(id, form);
        return "redirect:/admins/" + id;
    }

    // 削除
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        adminService.delete(id);
        return "redirect:/admins";
    }
}
