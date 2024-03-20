package com.fileDelete.fileMange.service;

import com.fileDelete.fileMange.domain.FileDomain;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FileMangeService {

    @Autowired
    private FileDomain domain;
    @Value("${file.path}")
    private String folderPath;
    Logger logger = LoggerFactory.getLogger(FileMangeService.class);

    /*
     * 시작 시, 최초 실행
     */
    @PostConstruct
    public void initialize() {
        domain.searchFiles(folderPath);
    }

    /*
     * 정오 12시마다 작업 진행
     */
    @Scheduled(cron = "0 0 12 * * ?")
    public void checkDelete() {
        try {
            domain.searchFiles(folderPath);
        } catch (Exception e) {
            logger.error("error",e);
        }
    }


}
