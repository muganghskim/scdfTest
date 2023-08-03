package com.example.scdfsource.service;

import com.example.scdfsource.model.RcsData;
import com.example.scdfsource.repository.RcsDataRepository;
import com.example.scdfsource.repository.TwoOutputSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@EnableBinding(TwoOutputSource.class)
@EnableScheduling
@Slf4j
public class RcsDataSourceService {
    @Autowired
    private MessageProducerService messageProducerService;

    @Autowired
    private RcsDataRepository rcsdatarepository;

    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        // 오늘 날짜 지정
        Date startDate = new Date();

        // 내일 날짜 지정
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();

        Integer LIMIT = 5000; // 행 제한 숫자 지정

        List<RcsData> fetchData = rcsdatarepository.findDataToProcess(startDate, endDate, LIMIT);


        for (RcsData data : fetchData) {
            log.info("data? : {}", data);
            try {
                boolean inserted = messageProducerService.produceMessage(data); // 데이터 전송

                log.info("submitting? : {}", inserted);

                if (inserted) {
                    log.info("Copy DB Update Success : {}", data.getOuid());

                    int updated = rcsdatarepository.updateReport(data.getOuid());

                    if (updated > 0) {
                        log.info("Original DB Report Update Success : {}",data.getOuid());
                    } else {
                        log.error("Original DB Report Update Fail : {}", data.getOuid());
                        log.error("Original DB Report Data renew or Data does not exist");
                    }

                } else {
                    log.info("Copy DB Update Fail");
                }
            } catch (Exception e) {
                log.error("Error executing scheduled task", e);
            }
        }
    }
}
