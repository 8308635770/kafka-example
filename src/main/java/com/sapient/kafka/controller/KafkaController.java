package com.sapient.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	
	@Autowired
	KafkaTemplate<String,String>kafkaTemplate;
	
	private static final String TOPIC="example-topic";
	
	
	@GetMapping("/publish/{message}")
	public String pushlishMessage(@PathVariable("message") String message) {
		
		kafkaTemplate.send(TOPIC,message);
		return "Published Succesfully";
	}
}
