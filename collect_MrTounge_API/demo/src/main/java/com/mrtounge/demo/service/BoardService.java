package com.mrtounge.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mrtounge.demo.dto.BoardAndPage;
import com.mrtounge.demo.entity.Board;

public interface BoardService {
    List<Board> getByList();
    List<Board> getByListOrderByIdDesc(int offset, int size);
    List<Board> getByListPage(Pageable pageable);
    BoardAndPage getByListAndTotalPage(Pageable pageable);
}
