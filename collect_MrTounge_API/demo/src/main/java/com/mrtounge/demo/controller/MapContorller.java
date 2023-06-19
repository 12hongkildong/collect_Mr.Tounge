package com.mrtounge.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mrtounge.demo.entity.Collect;
import com.mrtounge.demo.service.MapService;

@RestController
@RequestMapping("/main")
public class MapContorller {
  
    @Autowired
    private MapService service;

    @PostMapping("uploadImage")
    public String uploadImage(
        @RequestPart(name = "image") MultipartFile multipartFile,
        @RequestPart(name = "collect") Collect collect
    ) {
        System.out.println("콜렉트는 "+ collect);
        System.out.println("이미지는 "+ multipartFile);
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

    @GetMapping("collectData")
    public List<Collect> getCollectData(
        @RequestParam(name = "userId") Integer memberId
    ){

        List<Collect> collectList = service.getCollectData(memberId);
        System.out.println(collectList);
        return collectList;
    }
}
