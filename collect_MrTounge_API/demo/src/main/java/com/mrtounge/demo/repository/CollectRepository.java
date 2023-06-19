package com.mrtounge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrtounge.demo.entity.Collect;

public interface CollectRepository extends JpaRepository<Collect, Integer> {

    List<Collect> findByMemberId(Integer memberId);
    
}
