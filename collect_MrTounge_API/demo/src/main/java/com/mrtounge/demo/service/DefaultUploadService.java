package com.mrtounge.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mrtounge.demo.entity.Collect;
import com.mrtounge.demo.repository.CollectRepository;

@Service
public class DefaultUploadService implements UploadService{

    @Autowired
    private CollectRepository repository;

    @Override
    public void uploadMap(Collect collect, MultipartFile multipartFile) {
        String projectPath = System.getProperty("user.dir")+"/src/main/webapp/image/map";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid+"_"+multipartFile.getOriginalFilename();
        File saveImage = new File(projectPath,fileName);

        try {
            multipartFile.transferTo(saveImage);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Collect insertCollect = new Collect();
        insertCollect.setMemberId(collect.getMemberId());
        insertCollect.setInformation(collect.getInformation());
        insertCollect.setImgName(fileName);
        insertCollect.setLat(collect.getLat());
        insertCollect.setLng(collect.getLng());

        repository.save(insertCollect);

    }

    @Override
    public void uploadMap(MultipartFile multipartFile) {
        String projectPath = System.getProperty("user.dir")+"/src/main/webapp/image/map";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid+"_"+multipartFile.getOriginalFilename();
        File saveImage = new File(projectPath,fileName);

        try {
            multipartFile.transferTo(saveImage);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
    
}
