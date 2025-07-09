package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		System.out.println("LOGGING");
		System.out.println("Application Starting...");
		System.out.println();

		SpringApplication.run(SpringLearnApplication.class, args);

		System.out.println("LOGGING");
		System.out.println("Application Started Successfully.");
		System.out.println();
	}

}


