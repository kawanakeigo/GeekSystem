// src/main/java/com/example/demo/service/StoreService.java
package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store findById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }
}
