package com.mrtounge.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrtounge.demo.entity.Member;
import com.mrtounge.demo.service.SignService;

@RestController
@RequestMapping("sign")
public class SignController {

    @Autowired
    private SignService service;

    @PostMapping("send")
    public int send(
        @RequestBody Member member){
            
            return service.setAccount(member);
    }


}
