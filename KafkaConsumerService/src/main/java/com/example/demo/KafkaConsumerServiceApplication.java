package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class KafkaConsumerServiceApplication {

	
	@KafkaListener(topics="javamc",groupId="mygroup")
	public void consumeFromTopic(String message) {
		System.out.println("Consumer message:" +message);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerServiceApplication.class, args);
	}

}
