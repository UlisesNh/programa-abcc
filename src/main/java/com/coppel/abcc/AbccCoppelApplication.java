package com.coppel.abcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.coppel.abcc.repositorio")
public class AbccCoppelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbccCoppelApplication.class, args);
	}

}
