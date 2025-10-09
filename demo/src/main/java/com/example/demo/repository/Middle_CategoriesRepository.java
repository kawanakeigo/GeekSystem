package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Middle_Categories;

@Repository
public interface Middle_CategoriesRepository extends JpaRepository<Middle_Categories, Long>{
	List<Middle_Categories> findByLargeCategoriesId(Long largeCategoriesId);
	boolean existsByLargeCategoriesId(Long largeCategoriesId);

}
