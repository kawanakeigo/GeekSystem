package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Admin;
import com.example.demo.entity.LargeCategory;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
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
    
    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        StoreRepository storeRepository,
                        LargeCategoryRepository largeCategoryRepository
                        ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.largeCategoryRepository = largeCategoryRepository;
    }
    
    public List<Order> findAllOrders() {
        return orderRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public List<LargeCategory> getAllCategories() {
        return largeCategoryRepository.findAll();
    }
    
    
    
    @Transactional
    public Order createOrder(Long productId, Long storeId, Long quantity, Long categoriesId) {
        Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new IllegalArgumentException("商品が見つかりません"));
        Store store = storeRepository.findById(storeId)
                            .orElseThrow(() -> new IllegalArgumentException("店舗が見つかりません"));
        LargeCategory category = largeCategoryRepository.findById(categoriesId)
        					.orElseThrow(() ->new IllegalArgumentException("カテゴリが見つかりません"));
        
        Order order = new Order();
        order.setProduct(product);
        order.setStore(store);
        order.setQuantity(quantity);
        order.setLarge_categories_Id(categoriesId);
        order.setStatus("発注済み");  
        
        Admin admin = new Admin();
        admin.setId(1L);
        order.setAdmin(admin);
           
        return orderRepository.save(order);
    }
}

