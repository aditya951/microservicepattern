package com.twitter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.twitter.demo.repository")
public class TwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}

}
