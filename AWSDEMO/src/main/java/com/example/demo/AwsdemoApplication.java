package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/patient")
public class AwsdemoApplication {

	private List<Patient> pa=new ArrayList<>();
	
	
	@GetMapping
	public List<Patient> getAllPatient(){
		
		pa.add(new Patient("466", "ashu", "23"));
		
		return pa;
	}
	
	@PostMapping
	public Patient addPatient(@RequestBody Patient pat) {
		
		pa.add(pat);
		return pat;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AwsdemoApplication.class, args);
	}

	
	
	
}
