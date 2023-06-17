package com.mrtounge.demo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrtounge.demo.dto.BoardAndPage;
import com.mrtounge.demo.entity.Board;
import com.mrtounge.demo.repository.BoarderRepository;

@Service
public class DefaultBoardService implements BoardService {

    @Autowired
    private BoarderRepository repository;

    @Autowired
    private BoardAndPage boardAndPage;

    @Override
    public List<Board> getByList() {
 
        return repository.findAll();
    }

    @Override
    public List<Board> getByListOrderByIdDesc(int offset, int size) {
        return repository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Board> getByListPage(Pageable pageable) {
        // System.out.println(repository.findAll(pageable).getContent());
        
        System.out.println(repository.findAll(pageable).getTotalPages());
        
    //    return repository.findAll(pageable).getContent();
     return repository.findAll(pageable).getContent();
    };

    @Override
    public BoardAndPage getByListAndTotalPage(Pageable pageable) {
        // System.out.println(repository.findAll(pageable).getContent());
        
        System.out.println(repository.findAll(pageable).getTotalPages());
        
        boardAndPage.setBoardList(repository.findAll(pageable).getContent());
        boardAndPage.setTotalPages(repository.findAll(pageable).getTotalPages());
        

    //    return repository.findAll(pageable).getContent();
     return boardAndPage;
    }

    @Override
    public Optional<Board> getByListById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void updatePost(Integer id, String title, String content) {
        Optional<Board> article = repository.findById(id);
        if (article.isPresent()) {
            Board updateArticle = article.get();
            updateArticle.setTitle(title);
            updateArticle.setContent(content);
            updateArticle.setRegDate(new Timestamp(System.currentTimeMillis())); 

            repository.save(updateArticle);
            System.out.println(updateArticle);
            System.out.println(article);
        }
    };
}
