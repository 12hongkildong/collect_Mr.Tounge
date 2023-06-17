package com.mrtounge.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mrtounge.demo.entity.Collect;
import com.mrtounge.demo.service.UploadService;

@RestController
@RequestMapping("/main")
public class MapContorller {
  
    @Autowired
    private UploadService service;

    @PostMapping("uploadImage")
    public String uploadImage(
        @RequestPart(name="collect") Collect collect,
        @RequestPart(name="image", required=true) MultipartFile multipartFile
    ) throws IllegalStateException, IOException, Exception{
        service.uploadMap(collect, multipartFile);

        return "이미지 업로드";
    }

    @PostMapping("loadMap")
    public String uploadImage2(
        @RequestPart(name="image", required=true) MultipartFile multipartFile
    ) throws IllegalStateException, IOException, Exception{
        service.uploadMap(multipartFile);

        return "이미지 업로드";
    }
}
