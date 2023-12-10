package ru.rickheadle.dddwitheda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DddWithEdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddWithEdaApplication.class, args);
	}

}
