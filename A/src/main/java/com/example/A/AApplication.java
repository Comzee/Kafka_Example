package com.example.A;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AApplication {

	public static void main(String[] args) {
		SpringApplication.run(AApplication.class, args);

	}

	@Bean
	CommandLineRunner startMessageProducer(KafkaProducerService producerService) {
		return args -> {
			new Thread(producerService::produceMessage).start();
		};
	}

}
