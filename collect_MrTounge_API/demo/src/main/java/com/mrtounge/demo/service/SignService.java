package com.mrtounge.demo.service;

import org.springframework.stereotype.Service;

import com.mrtounge.demo.entity.Member;

@Service
public interface SignService {
    int setAccount(Member member);
}
