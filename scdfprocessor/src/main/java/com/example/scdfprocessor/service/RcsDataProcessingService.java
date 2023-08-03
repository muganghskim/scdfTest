package com.example.scdfprocessor.service;

import com.example.scdfprocessor.model.RcsData;
import com.example.scdfprocessor.model.RcsDataCalculate;
import com.example.scdfprocessor.processor.MultiOutputProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableBinding(MultiOutputProcessor.class)
@Slf4j
public class RcsDataProcessingService {
    @StreamListener(MultiOutputProcessor.INPUT1)
    @SendTo(MultiOutputProcessor.OUTPUT1)
    public RcsDataCalculate processMessage(RcsData rcsData) {
        log.info("Received rcsData: {}", rcsData);

        String inputDate = rcsData.getCreated_on().trim();
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");
        String outputDate = null;

        try {
            Date date = inputFormat.parse(inputDate);
            outputDate = outputFormat.format(date);
        } catch (ParseException e) {
            log.error("parse create_on error: {}", e);
        }

        RcsDataCalculate rcsDataCalculate = RcsDataCalculate.builder()
                .rcsGb(rcsData.getReq_path())
                .uptDate(rcsData.getUpdated_on())
                .grpCd(rcsData.getAccount_gid())
                .usrCd(rcsData.getAccount_sid())
                .telDiv(rcsData.getMno_code())
                .sndDt(outputDate)
                .totCnt(1)
                .okCnt(rcsData.getResult_code().equals("40000") ? 1 : 0)
                .failCnt(rcsData.getResult_code().equals("40000") ? 0 : 1)
                .build();


        // Return the transformed object
        log.info("submited rcsDataCalculate: {}", rcsDataCalculate);
        return rcsDataCalculate;
    }
}
