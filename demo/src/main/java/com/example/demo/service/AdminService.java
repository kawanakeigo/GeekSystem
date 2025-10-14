package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Authorities;
import com.example.demo.entity.Role;
import com.example.demo.entity.Store;
import com.example.demo.form.AdminForm;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.AuthoritiesRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.StoreRepository;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;
    private final StoreRepository storeRepository;
    private final AuthoritiesRepository authoritiesRepository;
    
    public AdminService(
    		AdminRepository adminRepository,
    		RoleRepository roleRepository,
    		StoreRepository storeRepository,
    		AuthoritiesRepository authoritiesRepository
    		) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
        this.storeRepository = storeRepository;
        this.authoritiesRepository = authoritiesRepository;
    }


    
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    
    public List<Authorities> getAllAuthorities() {
        return authoritiesRepository.findAll();
    }
    
    public List<Role> getAllRoll() {
        return roleRepository.findAll();
    }



    public void save(Admin admin) {
        adminRepository.save(admin);
    }
    
    //EntityをDTOに変換
    private AdminDTO convertToDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setEmail(admin.getEmail());
        dto.setPhonenumber(admin.getPhonenumber());
        dto.setRole(admin.getRole());
        dto.setStore(admin.getStore());
        dto.setAuthoritiesId(admin.getAuthoritiesId());
        return dto;
    }
    
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public AdminDTO getAdmin(Long id) {
        return adminRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    
    //新規作成
    @Transactional
    public Admin create(AdminForm form) {
    	Admin admin = new Admin();
    		admin.setFirstName(form.getFirstName());
    		admin.setLastName(form.getLastName());
    		admin.setEmail(form.getEmail());
    		admin.setPhonenumber(form.getPhonenumber());
    		admin.setPassword(form.getPassword());
    		admin.setAuthoritiesId(form.getAuthoritiesId());
    		
    		Role role =roleRepository.findById(form.getRoleId()).orElse(null);
    		admin.setRole(role);
    		
    		Store store = storeRepository.findById(form.getStoreId()).orElse(null);
    		admin.setStore(store);
    		
    		return adminRepository.save(admin);
    }
    
    @Transactional
    public Admin update(Long id, AdminForm form) {
    	Admin admin = adminRepository.findById(id).orElse(null);
    	if (admin == null) {
    		return null;
    	}
    	
    	admin.setFirstName(form.getFirstName());
		admin.setLastName(form.getLastName());
		admin.setEmail(form.getEmail());
		admin.setPhonenumber(form.getPhonenumber());
		admin.setAuthoritiesId(form.getAuthoritiesId());
		
		if (form.getPassword() != null && !form.getPassword().isEmpty()) {
            admin.setPassword(form.getPassword());
    }
		
		Role role =roleRepository.findById(form.getRoleId()).orElse(null);
		admin.setRole(role);
	
		return adminRepository.save(admin);
    }
    
    
    @Transactional
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
		
  }
    
    
