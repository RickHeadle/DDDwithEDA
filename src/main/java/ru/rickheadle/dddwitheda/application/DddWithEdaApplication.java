package ru.rickheadle.dddwitheda.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ru.rickheadle.dddwitheda")
@SpringBootApplication
public class DddWithEdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddWithEdaApplication.class, args);
	}

}
