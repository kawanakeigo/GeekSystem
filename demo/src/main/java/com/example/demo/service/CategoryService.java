package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LargeCategory;
import com.example.demo.entity.Middle_Categories;
import com.example.demo.entity.Small_Categories;
import com.example.demo.repository.LargeCategoryRepository;
import com.example.demo.repository.Middle_CategoriesRepository;
import com.example.demo.repository.Small_CategoriesRepository;

@Service
public class CategoryService {
	private final LargeCategoryRepository largeCategoryRepository;
    private final Middle_CategoriesRepository middleCategoryRepository;
    private final Small_CategoriesRepository smallCategoryRepository;
    
    public CategoryService(
    		LargeCategoryRepository largeRepository,
    		Middle_CategoriesRepository middleCategoryRepository,
    		Small_CategoriesRepository smallCategoryRepository
    		) {
        this.largeCategoryRepository = largeRepository;
        this.middleCategoryRepository = middleCategoryRepository;
        this.smallCategoryRepository = smallCategoryRepository;
    }
    
    //大カテゴリ
    public List<LargeCategory> getAllLargeRepository() {
        return largeCategoryRepository.findAll();
    }
    
    public List<LargeCategory> findAll() {
        return largeCategoryRepository.findAll();
    }
    
    public Optional<LargeCategory> getLargeCategoryById(Long id) {
        return largeCategoryRepository.findById(id);
    }
    
    public boolean existsByLargeCategoriesId(Long largeCategoryId) {
        return middleCategoryRepository.existsByLargeCategoriesId(largeCategoryId);
    }
    
    public List<Middle_Categories> getMiddleCategoriesByLargeId(Long largeId) {
        return middleCategoryRepository.findByLargeCategoriesId(largeId);
    }
    
    //中カテゴリ
    public List<Middle_Categories> getAllMiddleCategoryRepository() {
        return middleCategoryRepository.findAll();
    }
    
    public Optional<Middle_Categories> getMiddleCategoryById(Long id) {
        return middleCategoryRepository.findById(id);
    }
    
    public List<Small_Categories> getSmallCategoryByMiddleId(Long middleId) {
        return smallCategoryRepository.findByMiddleCategoriesId(middleId);
    }
    
    public boolean existsByMiddleCategoriesId(Long middleCategoryId) {
        return smallCategoryRepository.existsByMiddleCategoriesId(middleCategoryId);
    }
    
    //小カテゴリ
    public List<Small_Categories> getAllSmallCategoryRepository() {
        return smallCategoryRepository.findAll();
    }
    
    public Optional<Small_Categories> getSmallCategoryById(Long id) {
        return smallCategoryRepository.findById(id);
    }
    
    public List<?> getChildCategories(Long parentId) {
        if (existsByLargeCategoriesId(parentId)) {
            return getMiddleCategoriesByLargeId(parentId);
        }
        if (existsByMiddleCategoriesId(parentId)) {
            return getSmallCategoryByMiddleId(parentId);
        }
        return List.of();
    }
}
