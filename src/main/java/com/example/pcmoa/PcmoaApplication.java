package com.example.pcmoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PcmoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcmoaApplication.class, args);
	}

}
