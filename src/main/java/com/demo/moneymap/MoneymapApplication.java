package com.demo.moneymap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.demo.models", "com.demo.models.enums"})
@SpringBootApplication
public class MoneymapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneymapApplication.class, args);
	}

}
