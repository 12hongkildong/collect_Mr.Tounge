package com.mrtounge.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrtounge.demo.dto.BoardAndPage;
import com.mrtounge.demo.entity.Board;
import com.mrtounge.demo.service.BoardService;

@RestController
public class BoardController {
    
    @Autowired
    private BoardService service;

    @GetMapping("listall")
    public List<Board> listAll(){
        return service.getByListOrderByIdDesc(0,5);
    }

    @GetMapping("listallPage")
    public List<Board> listAllPage(
        @PageableDefault(size=5, sort="id", direction=Sort.Direction.DESC)Pageable pageable){
        return service.getByListPage(pageable);
    }

    @GetMapping("listallpagenation")
    public BoardAndPage listAllPageNation(
        @PageableDefault(size=5, sort="id", direction=Sort.Direction.DESC)Pageable pageable){
            BoardAndPage a = service.getByListAndTotalPage(pageable);
        return a;
    }

    @GetMapping("detailPage")
    public Optional<Board> detailPage(
        @RequestParam(name="id")Integer id){
            
        return service.getByListById(id);
    }

}
