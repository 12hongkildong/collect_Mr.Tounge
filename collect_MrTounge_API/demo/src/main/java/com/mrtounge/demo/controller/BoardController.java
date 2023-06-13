package com.mrtounge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrtounge.demo.entity.Board;
import com.mrtounge.demo.service.BoardService;

@RestController
public class BoardController {
    
    @Autowired
    private BoardService service;

    @GetMapping("listall")
    public List<Board> listAll(){
        

        return service.getByListOrderByIdDesc();
    }
}
