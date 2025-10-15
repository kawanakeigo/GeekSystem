package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Maker;

public interface MakerRepository extends JpaRepository<Maker, Long> {}