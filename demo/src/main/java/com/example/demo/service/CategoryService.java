package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.LargeCategoryDTO;
import com.example.demo.DTO.MiddleCategoryDTO;
import com.example.demo.DTO.SmallCategoryDTO;
import com.example.demo.entity.LargeCategory;
import com.example.demo.entity.MiddleCategory;
import com.example.demo.entity.SmallCategory;
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
    		Small_CategoriesRepository smallCategoryRepository) {
        this.largeCategoryRepository = largeRepository;
        this.middleCategoryRepository = middleCategoryRepository;
        this.smallCategoryRepository = smallCategoryRepository;
    }
    
    private LargeCategoryDTO convertLargeToDTO(LargeCategory largeCategory) {
        LargeCategoryDTO dto = new LargeCategoryDTO();
        dto.setId(largeCategory.getId());
        dto.setName(largeCategory.getName());
        return dto;
    }
    
    private MiddleCategoryDTO convertMiddleToDTO(MiddleCategory middleCategory) {
        MiddleCategoryDTO dto = new MiddleCategoryDTO();
        dto.setId(middleCategory.getId());
        dto.setName(middleCategory.getName());
        dto.setLargeCategoriesId(middleCategory.getLargeCategoriesId());
        return dto;
    }
    
    private SmallCategoryDTO convertSmallToDTO(SmallCategory snallCategory) {
        SmallCategoryDTO dto = new SmallCategoryDTO();
        dto.setId(snallCategory.getId());
        dto.setName(snallCategory.getName());
        dto.setMiddleCategoriesId(snallCategory.getMiddleCategoriesId());
        return dto;
    }
    
    public List<LargeCategoryDTO> getAllLargeCategories() {
        return largeCategoryRepository.findAll()
                .stream()
                .map(this::convertLargeToDTO)
                .collect(Collectors.toList());
    }
    
    public LargeCategoryDTO getLargeCategoryById(Long id) {
        return largeCategoryRepository.findById(id)
                .map(this::convertLargeToDTO)
                .orElse(null);
    }
    
    public List<MiddleCategoryDTO> getMiddleCategoriesByLargeId(Long largeId) {
        return middleCategoryRepository.findByLargeCategoriesId(largeId)
                .stream()
                .map(this::convertMiddleToDTO)
                .collect(Collectors.toList());
    }
    
    public MiddleCategoryDTO getMiddleCategoryById(Long id) {
        return middleCategoryRepository.findById(id)
                .map(this::convertMiddleToDTO)
                .orElse(null);
    }
    
    public List<SmallCategoryDTO> getSmallCategoriesByMiddleId(Long middleId) {
        return smallCategoryRepository.findByMiddleCategoriesId(middleId)
                .stream()
                .map(this::convertSmallToDTO)
                .collect(Collectors.toList());
    }
    
    public SmallCategoryDTO getSmallCategoryById(Long id) {
        return smallCategoryRepository.findById(id)
                .map(this::convertSmallToDTO)
                .orElse(null);
    }
    
    public List<CategoryDTO> getChildCategories(Long parentId) {
        if (middleCategoryRepository.existsByLargeCategoriesId(parentId)) {
        return middleCategoryRepository.findByLargeCategoriesId(parentId)
                .stream()
                .map(middle -> new CategoryDTO(middle.getId(), middle.getName()))
                .collect(Collectors.toList());
        }
        if (smallCategoryRepository.existsByMiddleCategoriesId(parentId)) {
        	return smallCategoryRepository.findByMiddleCategoriesId(parentId)
                    .stream()
                    .map(small -> new CategoryDTO(small.getId(), small.getName()))
                    .collect(Collectors.toList());
        }
        return List.of();
    }
}
