package com.TVgamers.TVgamers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(/*exclude={DataSourceAutoConfiguration.class}*/)
public class TVgamersApplication {

	public static void main(String[] args) {

		SpringApplication.run(TVgamersApplication.class, args);

		System.out.println("Hello, World!");
	}

}
