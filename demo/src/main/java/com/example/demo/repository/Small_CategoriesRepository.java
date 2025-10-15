package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SmallCategory;

@Repository
public interface Small_CategoriesRepository extends JpaRepository<SmallCategory, Long>{
	List<SmallCategory> findByMiddleCategoriesId(Long middleCategoriesId);
	boolean existsByMiddleCategoriesId(Long middleCategoriesId);
}
