package ru.rickheadle.dddwitheda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(value = "ru.rickheadle.dddwitheda.domain.repository")
@SpringBootApplication
public class DddWithEdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddWithEdaApplication.class, args);
	}

}
