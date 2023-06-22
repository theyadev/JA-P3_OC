package com.openclassrooms.P3_OC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class P3OcApplication {

	public static void main(String[] args) {
		SpringApplication.run(P3OcApplication.class, args);
	}

}
