package com.mrtounge.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.mrtounge.demo.dto.BoardAndPage;
import com.mrtounge.demo.entity.Board;

public interface BoardService {
    List<Board> getByList();
    List<Board> getByListOrderByIdDesc(int offset, int size);
    List<Board> getByListPage(Pageable pageable);
    BoardAndPage getByListAndTotalPage(Pageable pageable);
    Optional<Board> getByListById(Integer id);
    void updatePost(Integer id, String title, String content);
    void createPost(Integer memberId, String title, String content);
}
