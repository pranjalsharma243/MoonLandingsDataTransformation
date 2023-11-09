package com.moonlandings;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MoonLandingsApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(MoonLandingsApplication.class, args)));

	}

}
