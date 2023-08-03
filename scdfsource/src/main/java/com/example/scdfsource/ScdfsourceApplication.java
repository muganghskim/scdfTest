package com.example.scdfsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScdfsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScdfsourceApplication.class, args);
	}


//	public void triggerMessageProduction() {
//		messageProducerService.produceMessage();
//		log.info("Sent message: Hello, SCDF!");
//	}

}
