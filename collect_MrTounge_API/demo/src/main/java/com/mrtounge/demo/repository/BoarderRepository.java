package com.mrtounge.demo.repository;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrtounge.demo.entity.Board;

@Repository
public interface BoarderRepository extends JpaRepository<Board, Integer> {
    // @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAllByOrderByIdDesc();

    Page<Board> findAll(Pageable pageable);

    // Board updatePost(Long id, String title, String content, Timestamp currentTimestamp);

}
