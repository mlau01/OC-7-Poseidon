package com.nnk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	final static public String CONSTRAINT_MESSAGE_125CHAR = "The field must be less than 125 characters";
	final static public String CONSTRAINT_MESSAGE_30CHAR = "The field must be less than 30 characters";
	final static public String CONSTRAINT_MESSAGE_10CHAR = "The field must be less than 10 characters";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
