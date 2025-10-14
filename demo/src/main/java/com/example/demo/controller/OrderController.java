package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.OrderForm;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService
                           ) {
        this.orderService = orderService;
    }
    
    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("categories", orderService.getAllCategories());
        model.addAttribute("products", orderService.getAllProducts());
        model.addAttribute("stores", orderService.getAllStores());
        model.addAttribute("orderForm", new OrderForm());
        return "order-form";
    }
    
    @PostMapping
    public String createOrder(@Valid @ModelAttribute ("orderForm") OrderForm orderForm,BindingResult result) {
    	if (result.hasErrors()) {
        return "redirect:/orders";
    }
    	orderService.createOrder(
                orderForm.getProductId(),
                orderForm.getStoreId(),
                orderForm.getQuantity(),
                orderForm.getCategoryId()
                );
    	return "redirect:/orders";
    }
    
    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "order-list";
    }
}