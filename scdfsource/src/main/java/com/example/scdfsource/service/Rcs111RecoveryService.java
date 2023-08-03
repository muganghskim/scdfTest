//package com.example.scdfsource.service;
//
//import com.example.scdfsource.model.RcsData;
//import com.example.scdfsource.oramodel.Rcs000Recovery;
//import com.example.scdfsource.oramodel.Rcs111Recovery;
//import com.example.scdfsource.orarepository2.Rcs111Repository;
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
//public class Rcs111RecoveryService {
//    @Autowired
//    private MessageProducerService messageProducerService;
//
//    @Autowired
//    private Rcs111Repository rcs111Repository;
//
//    @Autowired
//    private RcsDataRepository rcsdatarepository;
//
//    @Scheduled(fixedRate = 5000)
//    public void Recovery2scheduledTask() {
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
//        Optional<Rcs111Recovery> existingData = rcs111Repository.findByRecoveryFlag2("Y");
//
//        List<RcsData> fetchData = rcsdatarepository.findRecoveryToProcess(startDate, endDate, LIMIT);
//
//        if(existingData.isPresent()){
//            rcs111Repository.deleteRecovery2(existingData.get().getId());
//            for (RcsData data : fetchData) {
//                log.info("data? : {}", data);
//                try {
//                    boolean inserted = messageProducerService.Recoveryproduce2Message(data); // 데이터 전송
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
