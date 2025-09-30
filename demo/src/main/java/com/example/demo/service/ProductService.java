package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Products;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Products> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
    public Products findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Products save(Products product) {
        return productRepository.save(product);
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
