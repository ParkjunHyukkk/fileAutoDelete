package com.fileDelete.fileMange.common;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
}
