package com.dailycodebuffer.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
        System.out.println("Console test log");
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
