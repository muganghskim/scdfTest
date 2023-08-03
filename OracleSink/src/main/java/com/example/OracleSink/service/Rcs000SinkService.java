package com.example.OracleSink.service;

import com.example.OracleSink.model.Rcs000Calculate;
import com.example.OracleSink.repository.Data000Repository;
import com.example.OracleSink.repository.MultiInputSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@EnableBinding(MultiInputSink.class)
@Slf4j
public class Rcs000SinkService {
    @Autowired
    private Data000Repository data000Repository;

    @StreamListener(MultiInputSink.INPUT2)
    public void processMessage2(Rcs000Calculate rcs000Calculate) {

        SimpleDateFormat currentFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDateStr = currentFormat.format(new Date());

        log.info("Received object: {}", rcs000Calculate);

        Optional<Rcs000Calculate> existingData2 = data000Repository.findByselect(
                rcs000Calculate.getGrpCd(),
                rcs000Calculate.getUsrCd(),
                rcs000Calculate.getSndDt(),
                rcs000Calculate.getWrtHh(),
                rcs000Calculate.getMbrId(),
                rcs000Calculate.getAuthSeq(),
                rcs000Calculate.getMnoCd(),
                rcs000Calculate.getClientIp(),
                rcs000Calculate.getClientPort(),
                rcs000Calculate.getReqPath(),
                rcs000Calculate.getChatbotId(),
                rcs000Calculate.getTemplateId(),
                rcs000Calculate.getNatCd(),
                rcs000Calculate.getAgencyId(),
                rcs000Calculate.getGroupId(),
                rcs000Calculate.getRsrvdId(),
                rcs000Calculate.getMnoClientId(),
                rcs000Calculate.getMnoHost(),
                rcs000Calculate.getMnoPort(),
                rcs000Calculate.getMnoRootPath(),
                rcs000Calculate.getMnoCode(),
                rcs000Calculate.getRsltVal(),
                rcs000Calculate.getStatusCode()
        );



        // Update the counts if there is existing data with the same variables
        if (existingData2.isPresent()) {
            Rcs000Calculate updatedData = existingData2.get();
            updatedData.setUptDate(rcs000Calculate.getUptDate());
            updatedData.setSmsCnt(updatedData.getSmsCnt() + rcs000Calculate.getSmsCnt());
            data000Repository.save(updatedData);
            log.info("Object updated with new counts.");
        } else {
            data000Repository.save(rcs000Calculate);
            log.info("Object saved to Oracle Database.");
        }
    }
}
