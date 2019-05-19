package com.saalamsaifi.randomdatagenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.saalamsaifi")
public class RandomDataGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomDataGeneratorApplication.class, args);
	}
}
