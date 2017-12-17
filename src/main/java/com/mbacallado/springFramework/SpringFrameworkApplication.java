package com.mbacallado.springFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.mbacallado.springFramework.repository")
public class SpringFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkApplication.class, args);
	}
}
