package com.mrtounge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrtounge.demo.entity.Board;
import com.mrtounge.demo.repository.BoarderRepository;

@Service
public class DefaultBoardService implements BoardService {

    @Autowired
    private BoarderRepository repository;

    @Override
    public List<Board> getByList() {
 
        return repository.findAll();
    };
}
