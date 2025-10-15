package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductDTO;
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
    
    private  ProductDTO convertToDTO(Products product) {
    	ProductDTO dto = new ProductDTO();
    	dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setLargeCategoryId(product.getLarge_categories_Id());
        dto.setMiddleCategoryId(product.getMiddle_categories_Id());
        dto.setSmallCategoryId(product.getSmall_categories_Id());
        dto.setMakerId(product.getMakerId());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        
        return dto;
    }
    
    private Products convertToEntity(ProductDTO dto) {
        Products product = new Products();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setLarge_categories_Id(dto.getLargeCategoryId());
        product.setMiddle_categories_Id(dto.getMiddleCategoryId());
        product.setSmall_categories_Id(dto.getSmallCategoryId());
        product.setMakerId(dto.getMakerId());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        return product;
    }
    
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    
    public List<ProductDTO> findByLargeCategoryId(Long categoryId) {
        return productRepository.findByLargeCategoryId(categoryId)
        		.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
    }
    
    public List<ProductDTO> findByMiddleCategoryId(Long categoryId) {
        return productRepository.findByMiddleCategoryId(categoryId)
        		.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
    }
    
    public List<ProductDTO> findBySmallCategoryId(Long categoryId) {
        return productRepository.findBySmallCategoryId(categoryId)
        		.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
    }
    
    public List<LargeCategory> getAllCategories() {
        return largeCategoryRepository.findAll();
    }
    
    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
        		.map(this::convertToDTO)
                .orElse(null);
    }
    
    public void save(ProductDTO productDto) {
    	Products entity = convertToEntity(productDto);
        productRepository.save(entity);
    }
    
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
