package com.mrtounge.demo.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mrtounge.demo.entity.Board;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class BoardAndPage {
    private List<Board> boardList;
    private int totalPages;


    public BoardAndPage(){

    }

    public BoardAndPage(List<Board> boardList, int totalPages){
        this.boardList=boardList;
        this.totalPages=totalPages;
    }


}
