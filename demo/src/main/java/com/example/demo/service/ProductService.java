package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LargeCategory;
import com.example.demo.entity.Products;
import com.example.demo.repository.LargeCategoryRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	 private final LargeCategoryRepository largeCategoryRepository;
    public ProductService(ProductRepository productRepository,
    		LargeCategoryRepository largeCategoryRepository
    		) {
        this.productRepository = productRepository;
        this.largeCategoryRepository = largeCategoryRepository;
    }
    
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
    
    public List<Products> findByLargeCategoryId(Long categoryId) {
        return productRepository.findByLargeCategoryId(categoryId);
    }
    
    public List<Products> findByMiddleCategoryId(Long categoryId) {
        return productRepository.findByMiddleCategoryId(categoryId);
    }
    
    public List<Products> findBySmallCategoryId(Long categoryId) {
        return productRepository.findBySmallCategoryId(categoryId);
    }
    
    public List<LargeCategory> getAllCategories() {
        return largeCategoryRepository.findAll();
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
