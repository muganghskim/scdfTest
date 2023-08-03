package com.example.OracleSink.service;

import com.example.OracleSink.model.RcsDataCalculate;
import com.example.OracleSink.repository.DataSinkRepository;
import com.example.OracleSink.repository.MultiInputSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.Optional;

@EnableBinding(MultiInputSink.class)
@Slf4j
public class RcsDataSinkService {
    @Autowired
    private DataSinkRepository dataSinkRepository;

    @StreamListener(MultiInputSink.INPUT1)
    public void processMessage(RcsDataCalculate rcsDataCalculate) {

        log.info("Received object: {}", rcsDataCalculate);

        Optional<RcsDataCalculate> existingData = dataSinkRepository.findByRcsGbAndGrpCdAndUsrCdAndTelDivAndSndDt(
                rcsDataCalculate.getRcsGb(),
                rcsDataCalculate.getGrpCd(),
                rcsDataCalculate.getUsrCd(),
                rcsDataCalculate.getTelDiv(),
                rcsDataCalculate.getSndDt()
        );

        // Update the counts if there is existing data with the same variables
        if (existingData.isPresent()) {
            RcsDataCalculate updatedData = existingData.get();
            updatedData.setUptDate(rcsDataCalculate.getUptDate());
            updatedData.setTotCnt(updatedData.getTotCnt() + rcsDataCalculate.getTotCnt());
            updatedData.setOkCnt(updatedData.getOkCnt() + rcsDataCalculate.getOkCnt());
            updatedData.setFailCnt(updatedData.getFailCnt() + rcsDataCalculate.getFailCnt());
            dataSinkRepository.save(updatedData);
            log.info("Object updated with new counts.");
        } else {
            dataSinkRepository.save(rcsDataCalculate);
            log.info("Object saved to Oracle Database.");
        }
    }
}
