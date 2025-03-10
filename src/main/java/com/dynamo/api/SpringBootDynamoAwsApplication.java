package com.dynamo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootDynamoAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDynamoAwsApplication.class, args);
	}

	@PostMapping("/hello")
	public String getHello() {
		return "Hello World DynamoDB";
	}
}
