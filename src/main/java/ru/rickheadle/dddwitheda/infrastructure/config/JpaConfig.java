package ru.rickheadle.dddwitheda.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(value = "ru.rickheadle.dddwitheda.infrastructure.repository")
public class JpaConfig {

}
