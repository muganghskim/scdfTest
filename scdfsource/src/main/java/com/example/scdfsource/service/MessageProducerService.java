package com.example.scdfsource.service;

import com.example.scdfsource.model.RcsData;
import com.example.scdfsource.repository.TwoOutputSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducerService {

    private final ObjectMapper objectMapper;

    public MessageProducerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Autowired
    private TwoOutputSource twoOutputSource;

    public boolean produceMessage(RcsData data) {
        try {
            log.info("try data submit");

            String jsonData = objectMapper.writeValueAsString(data);

            // Logging JSON data
            log.info("Sending JSON data: {}", jsonData);

//            source.output().send(MessageBuilder.withPayload(jsonData)
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build());
            sendToOutput1(jsonData);
            sendToOutput2(jsonData);

            return true;
        } catch(Exception e) {
            // Print the stack trace for better error details
            log.error("An error occurred while sending data:", e);
            return false;
        }
    }
    public void sendToOutput1(String jsonData){
        twoOutputSource.output1().send(MessageBuilder.withPayload(jsonData)
                .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build());
    }

    public void sendToOutput2(String jsonData){
        twoOutputSource.output2().send(MessageBuilder.withPayload(jsonData)
                .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build());
    }

//    public boolean RecoveryproduceMessage(RcsData data) {
//        try {
//            log.info("try data submit");
//
//            String jsonData = objectMapper.writeValueAsString(data);
//
//            // Logging JSON data
//            log.info("Sending JSON data: {}", jsonData);
//
//            source.output().send(MessageBuilder.withPayload(jsonData)
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build());
//            return true;
//        } catch(Exception e) {
//            // Print the stack trace for better error details
//            log.error("An error occurred while sending data:", e);
//            return false;
//        }
//    }
//
//    public boolean Recoveryproduce2Message(RcsData data) {
//        try {
//            log.info("try data submit");
//
//            String jsonData = objectMapper.writeValueAsString(data);
//
//            // Logging JSON data
//            log.info("Sending JSON data: {}", jsonData);
//
//            source.output().send(MessageBuilder.withPayload(jsonData)
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build());
//            return true;
//        } catch(Exception e) {
//            // Print the stack trace for better error details
//            log.error("An error occurred while sending data:", e);
//            return false;
//        }
//    }


}