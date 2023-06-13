package com.mrtounge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrtounge.demo.entity.Board;

public interface BoarderRepository extends JpaRepository<Board, Integer> {
    // @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAllByOrderByIdDesc();
}
