package com.mrtounge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrtounge.demo.entity.Member;
import com.mrtounge.demo.repository.MemberRepository;

@Service
public class DefaultSignSerivce implements SignService{

    @Autowired
    private MemberRepository repository;



    @Override
    public int setAccount(Member member) {
        
        List<Member> list = repository.findAll();

        for(Member account : list){
            if(account.getEmail().equals(member.getEmail()) || account.getNickname().equals(member.getNickname()))
                return 0; // 이메일or닉네임 중복됨
        }
        repository.save(member);
        return 1; 
    }
    
}
