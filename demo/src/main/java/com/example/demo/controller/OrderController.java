package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.OrderForm;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final CategoryService categoryService; 
    public OrderController(OrderService orderService,
                           ProductRepository productRepository,
                           StoreRepository storeRepository,
                           CategoryService categoryService) {
        this.orderService = orderService;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.categoryService = categoryService;
    }
    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("categories", categoryService.getParentCategories());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("stores", storeRepository.findAll());
        model.addAttribute("orderForm", new OrderForm());
        return "order-form";
    }
    @PostMapping
    public String createOrder(@Valid @ModelAttribute ("orderForm") OrderForm orderForm) {
        orderService.createOrder(orderForm.getProductId(), orderForm.getStoreId(), orderForm.getQuantity());
        return "redirect:/orders";
    }
    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "order-list";
    }
}