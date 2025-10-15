package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MiddleCategory;

@Repository
public interface Middle_CategoriesRepository extends JpaRepository<MiddleCategory, Long>{
	List<MiddleCategory> findByLargeCategoriesId(Long largeCategoriesId);
	boolean existsByLargeCategoriesId(Long largeCategoriesId);
}
