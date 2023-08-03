package com.example.scdfprocessor.service;

import com.example.scdfprocessor.model.Rcs000Calculate;
import com.example.scdfprocessor.model.RcsData;
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
public class Rcs000ProcessingService {
    @StreamListener(MultiOutputProcessor.INPUT2)
    @SendTo(MultiOutputProcessor.OUTPUT2)
    public Rcs000Calculate processMessage2(RcsData rcsData) {
        log.info("Received rcsData: {}", rcsData);

        String inputDate = rcsData.getCreated_on().trim();

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputTimeFormat = new SimpleDateFormat("HH");

        String outputDate = null;
        String outputTime = null;
        try {
            Date date = inputFormat.parse(inputDate);
            outputDate = outputFormat.format(date);
            outputTime = outputTimeFormat.format(date);
        } catch (ParseException e) {
            log.error("parse create_on error: {}", e);
        }

        String inputString = rcsData.getAccount_uid();
        String[] parts = inputString.split("\\.");

        String outputMbrid = parts[0];
        String outputAuthseq = parts[1];



        Rcs000Calculate rcs000Calculate = Rcs000Calculate.builder()
                .sndDt(outputDate)
                .wrtHh(outputTime)
                .grpCd(rcsData.getAccount_gid())
                .mbrId(outputMbrid)
                .authSeq(outputAuthseq)
                .reqPath(rcsData.getReq_path())
//                .uptDate(rcsData.getUpdated_on())
//                .grpCd(rcsData.getAccount_gid())
                .usrCd(rcsData.getAccount_sid())
                .mnoCd(rcsData.getPnx_code().toUpperCase())
                .clientIp(rcsData.getClient_ip())
                .clientPort(rcsData.getClient_port())
                .rsltVal(rcsData.getResult_code())
                .chatbotId(rcsData.getChatbot_id())
                .templateId(rcsData.getTemplate_id())
                .natCd(rcsData.getCountry_code())
                .agencyId(rcsData.getAgency_id())
                .groupId(rcsData.getGroup_id())
                .rsrvdId(rcsData.getRsrvd_id())
                .mnoClientId(rcsData.getMno_client_id())
                .mnoHost(rcsData.getMno_host())
                .mnoPort(rcsData.getMno_port())
                .mnoRootPath(rcsData.getMno_root_path())
                .mnoCode(rcsData.getMno_code())
                .statusCode(rcsData.getStatus_code())
                .smsCnt(1)
//                .telDiv(rcsData.getMno_code())
//                .sndDt(String.valueOf(LocalDate.now()))
//                .totCnt(1)
//                .okCnt(rcsData.getResult_code().equals("40000") ? 1 : 0)
//                .failCnt(rcsData.getResult_code().equals("40000") ? 0 : 1)
                .build();


        // Return the transformed object
        log.info("submited rcsDataCalculate: {}", rcs000Calculate);
        return rcs000Calculate;
    }
}
