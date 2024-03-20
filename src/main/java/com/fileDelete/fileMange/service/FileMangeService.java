package com.fileDelete.fileMange.service;

import com.fileDelete.fileMange.domain.FileDomain;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileMangeService {

    @Autowired
    private FileDomain domain;
    @Value("${file.path}")
    private String folderPath;


    @PostConstruct
    public void sync(){
        domain.searchFiles(folderPath);
    }





}
