package com.mrtounge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrtounge.demo.entity.Board;

public interface BoarderRepository extends JpaRepository<Board, Integer> {
    
}
