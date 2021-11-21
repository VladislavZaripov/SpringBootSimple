package com.zaripov.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class JokeApplication {

	public JokeApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(JokeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	private final JdbcTemplate jdbcTemplate;
	@PostConstruct
	public void initDB(){
		jdbcTemplate.update("create table if not exists jokes (joke text)");
	}
}