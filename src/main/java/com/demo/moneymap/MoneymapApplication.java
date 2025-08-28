package com.demo.moneymap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.demo.models", "com.demo.models.enums"})
@EnableJpaRepositories(basePackages = {"com.demo.repositories"})
@SpringBootApplication
public class MoneymapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneymapApplication.class, args);
	}

}
