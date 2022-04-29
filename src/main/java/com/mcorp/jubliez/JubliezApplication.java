package com.mcorp.jubliez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@SpringBootApplication
@EnableR2dbcAuditing
public class JubliezApplication {

	public static void main(String[] args) {
		SpringApplication.run(JubliezApplication.class, args);
	}

}
