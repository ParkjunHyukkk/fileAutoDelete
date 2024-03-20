package com.fileDelete.fileMange.common;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class FileUtil {


    /*
     * 기준일 - 파일 수정일 기준 비교 기능
     */
    public long getDaysBetween(String baseDate , String targetDate) {
        long BetweenResult = 0;

        LocalDate formatBaseDate = LocalDate.parse(baseDate);
        LocalDate formatTagetDate = LocalDate.parse(targetDate);

        BetweenResult = Math.abs(ChronoUnit.DAYS.between(formatBaseDate, formatTagetDate));

        return BetweenResult;
    }

    /*
     * 포맷팅 - 파일 최종 수정일
     */
    public String simpleDataFormat(long fileUpdateDat){
        String formatDate = "";

        // 파일 수정일 날짜 포맷
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        formatDate = simpleDate.format(new Date(fileUpdateDat));

        return formatDate;
    }
}
