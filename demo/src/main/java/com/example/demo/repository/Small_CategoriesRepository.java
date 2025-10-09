package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Small_Categories;

@Repository
public interface Small_CategoriesRepository extends JpaRepository<Small_Categories, Long>{
	List<Small_Categories> findByMiddleCategoriesId(Long middleCategoriesId);
	boolean existsByMiddleCategoriesId(Long middleCategoriesId);
}
