package com.example.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;

import com.example.demo.entity.Makers;
import com.example.demo.repository.MakerRepository;

public class MakerService {
	private final MakerRepository makerRepository;

    public MakerService(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }
    
    public List<Makers> getAllMakers() {
        return makerRepository.findAll();
    }
    
    public Makers getMakerById(Long id) {
        return makerRepository.findById(id).orElse(null);
    }
    
    //新規作成
    @Transactional
    public Makers createMaker(Makers maker) {
        return makerRepository.save(maker);
    }
    
   //編集
    @Transactional
    public Makers updateMaker(Makers maker) {
        return makerRepository.save(maker);
    }
    
    //削除
    @Transactional
    public void deleteMaker(Long id) {
        makerRepository.deleteById(id);
    }
        
}
