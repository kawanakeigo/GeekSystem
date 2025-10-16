// src/main/java/com/example/demo/service/StoreService.java
package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.StoreDTO;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    public StoreService(StoreRepository storeRepository
    ) {
        this.storeRepository = storeRepository;
    }
    
    public List<StoreDTO> findAll(
    ) {
        return storeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public StoreDTO findById(
    	Long id
    ) {
        return storeRepository.findById(id)
        		.map(this::convertToDTO)
                .orElse(null);
    }
    
    
    public void save(
    	StoreDTO storeDto
    ) {
    	Store entity = convertToEntity(storeDto);
        storeRepository.save(entity);
    }
    
    public void deleteById(
    	Long id
    ) {
        storeRepository.deleteById(id);
    }
    
    private StoreDTO convertToDTO(
    	Store store
    ) {
    	StoreDTO dto = new StoreDTO();
    	dto.setId(store.getId());
    	dto.setName(store.getName());
    	dto.setLocation(store.getLocation());
    	return dto;
        }
    private Store convertToEntity(
    	StoreDTO dto
    ) {
    	Store store = new Store();
    	store.setId(dto.getId());
    	store.setName(dto.getName());
    	store.setLocation(dto.getLocation());
    	return store;
    }
}
