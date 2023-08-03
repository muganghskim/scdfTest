//package com.example.scdfsource.service;
//
//import com.example.scdfsource.model.RcsData;
//import com.example.scdfsource.oramodel.Rcs000Recovery;
//import com.example.scdfsource.orarepository.Rcs000Repository;
//import com.example.scdfsource.repository.RcsDataRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@EnableBinding(Source.class)
//@EnableScheduling
//@Slf4j
//public class Rcs000RecoveryService {
//    @Autowired
//    private MessageProducerService messageProducerService;
//
//    @Autowired
//    private Rcs000Repository rcs000Repository;
//
//    @Autowired
//    private RcsDataRepository rcsdatarepository;
//
//    @Scheduled(fixedRate = 5000)
//    public void RecoveryscheduledTask() {
//        // 오늘 날짜 지정
//        Date startDate = new Date();
//
//        // 내일 날짜 지정
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, 1);
//        Date endDate = calendar.getTime();
//
//        Integer LIMIT = 5000; // 행 제한 숫자 지정
//
//        Optional<Rcs000Recovery> existingData = rcs000Repository.findByRecoveryFlag("Y");
//
//        List<RcsData> fetchData = rcsdatarepository.findRecoveryToProcess(startDate, endDate, LIMIT);
//
//        if(existingData.isPresent()){
//            rcs000Repository.deleteRecovery(existingData.get().getId());
//            for (RcsData data : fetchData) {
//                log.info("data? : {}", data);
//                try {
//                    boolean inserted = messageProducerService.RecoveryproduceMessage(data); // 데이터 전송
//
//                    log.info("submitting? : {}", inserted);
//
//                    if (inserted) {
//                        log.info("Copy DB Recovery Success : {}", data.getOuid());
//
//                    } else {
//                        log.info("Copy DB Recovery Fail");
//                    }
//                } catch (Exception e) {
//                    log.error("Error executing scheduled task", e);
//                }
//            }
//        }
//    }
//}
