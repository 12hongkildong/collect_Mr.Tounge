package com.mrtounge.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mrtounge.demo.entity.Collect;

@Service
public interface MapService {
    void uploadMap(Collect collect, MultipartFile multipartFile);
    void uploadMap(MultipartFile multipartFile);

    List<Collect> getCollectData(Integer memberId);
}
