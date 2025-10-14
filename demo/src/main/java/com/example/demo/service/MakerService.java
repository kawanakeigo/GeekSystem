package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import com.example.demo.DTO.MakerDTO;
import com.example.demo.entity.Makers;
import com.example.demo.repository.MakerRepository;

public class MakerService {
	private final MakerRepository makerRepository;

    public MakerService(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }
    
    private MakerDTO convertToDTO(Makers maker) {
        MakerDTO dto = new MakerDTO();
        dto.setId(maker.getId());
        dto.setName(maker.getName());
        return dto;
    }
    
    public List<MakerDTO> getAllMakers() {
        return makerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public MakerDTO getMakerById(Long id) {
        return makerRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
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
