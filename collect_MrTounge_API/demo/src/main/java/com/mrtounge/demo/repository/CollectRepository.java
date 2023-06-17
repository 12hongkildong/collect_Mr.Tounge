package com.mrtounge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrtounge.demo.entity.Collect;

public interface CollectRepository extends JpaRepository<Collect, Integer> {
    
}
