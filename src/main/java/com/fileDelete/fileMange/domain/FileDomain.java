package com.fileDelete.fileMange.domain;


import com.fileDelete.fileMange.common.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class FileDomain {

    @Autowired
    FileUtil util;

    @Value("${base.day}")
    private long baseDay;

    Logger logger = LoggerFactory.getLogger(FileDomain.class);

    /*
     * 파일 탐색
     */
    public void searchFiles(String path) {

        // 오늘 날짜 출력
        LocalDate today = LocalDate.now();

        File folder = new File(path);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 재귀 함수를 통해, 모든 파일 탐색
                    searchFiles(file.getAbsolutePath());
                } else {
                    long lastModified = file.lastModified();

                    // 계산식 = 기준일 - 파일수정(생성)일
                    long resultDay = util.getDaysBetween(today.toString(), util.simpleDataFormat(lastModified));

                    if (resultDay >= baseDay) { // 30일
                        if (file.delete()) {
                            logger.info("파일 삭제 : " + file.getAbsolutePath());
                        } else {
                            logger.info("파일 삭제 실패 : " + file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}
