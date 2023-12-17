package ru.rickheadle.dddwitheda.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = "ru.rickheadle.dddwitheda.domain.model")
@EnableJpaRepositories(value = "ru.rickheadle.dddwitheda.infrastructure.repository")
public class JpaConfig {

}
