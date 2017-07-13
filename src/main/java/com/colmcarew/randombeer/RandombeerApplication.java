package com.colmcarew.randombeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RandombeerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.livereload.enabled", "true");
		SpringApplication.run(RandombeerApplication.class, args);
	}
}
