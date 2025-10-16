package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import com.example.demo.DTO.MakerDTO;
import com.example.demo.entity.Maker;
import com.example.demo.form.MakerForm;
import com.example.demo.repository.MakerRepository;

public class MakerService {
	private final MakerRepository makerRepository;

    public MakerService(
    	MakerRepository makerRepository
    ) {
        this.makerRepository = makerRepository;
    }
    
    private MakerDTO convertToDTO(
    	Maker maker
    ) {
        MakerDTO dto = new MakerDTO();
        dto.setId(maker.getId());
        dto.setName(maker.getName());
        return dto;
    }
    
    private MakerForm convertToForm(
    	Maker maker
    ) {
        MakerForm form = new MakerForm();
        form.setId(maker.getId());
        form.setName(maker.getName());
        return form;
    }
    
    private Maker convertToEntity(
    	MakerForm form
    ) {
        Maker maker = new Maker();
        maker.setId(form.getId());
        maker.setName(form.getName());
        return maker;
    }
    
    public List<MakerDTO> getAllMakers(
    ) {
        return makerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public MakerDTO getMakerById(
    	Long id
    ) {
        return makerRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    
    public MakerForm getMakerFormById(
    	Long id
    ) {
        return makerRepository.findById(id)
                .map(this::convertToForm)
                .orElse(null);
    }
    
    //新規作成
    @Transactional
    public Maker createMaker(
    	MakerForm form
    ) {
    	Maker maker = convertToEntity(form);
        return makerRepository.save(maker);
    }
    
   //編集
    @Transactional
    public Maker updateMaker(
    	MakerForm form
    ) {
    	Maker maker = convertToEntity(form);
        return makerRepository.save(maker);
    }
    
    //削除
    @Transactional
    public void deleteMaker(
    	Long id
    ) {
        makerRepository.deleteById(id);
    }
}
