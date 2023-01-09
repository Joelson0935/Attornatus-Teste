package com.casa.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AttornatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttornatusApplication.class, args);
	}

}
