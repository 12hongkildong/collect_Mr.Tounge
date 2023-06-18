package com.mrtounge.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mrtounge.demo.entity.Collect;

@Service
public interface UploadService {
    void uploadMap(Collect collect, MultipartFile multipartFile);
    void uploadMap(MultipartFile multipartFile);

}
