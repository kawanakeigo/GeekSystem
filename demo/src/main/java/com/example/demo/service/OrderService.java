package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Admin;
import com.example.demo.entity.LargeCategory;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.form.OrderForm;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.LargeCategoryRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final LargeCategoryRepository largeCategoryRepository;
    private final AdminRepository adminRepository;
    
    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        StoreRepository storeRepository,
                        LargeCategoryRepository largeCategoryRepository,
                        AdminRepository adminRepository
    ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.largeCategoryRepository = largeCategoryRepository;
        this.adminRepository = adminRepository;
    }
    
    public List<Order> findAllOrders(
    ) {
        return orderRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public List<Store> getAllStores(
    ) {
        return storeRepository.findAll();
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public List<LargeCategory> getAllCategories(
   ) {
        return largeCategoryRepository.findAll();
    }
    
    
    
    @Transactional
    public Order createOrder(
    	OrderForm form
    ) {
        Product product = productRepository.findById(form.getProductId())
                            .orElseThrow(() -> new IllegalArgumentException("商品が見つかりません"));
        Store store = storeRepository.findById(form.getStoreId())
                            .orElseThrow(() -> new IllegalArgumentException("店舗が見つかりません"));
        LargeCategory category = largeCategoryRepository.findById(form.getCategoryId())
        					.orElseThrow(() ->new IllegalArgumentException("カテゴリが見つかりません"));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("ログイン中の管理者が見つかりません"));
        
        Order order = new Order();
        order.setProduct(product);
        order.setStore(store);
        order.setQuantity(form.getQuantity());
        order.setLarge_categories_Id(category.getId());
        order.setStatus("発注済み");  
        order.setAdmin(admin);
           
        return orderRepository.save(order);
    }
}

