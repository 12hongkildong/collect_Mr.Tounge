package com.mrtounge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrtounge.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
    
}
