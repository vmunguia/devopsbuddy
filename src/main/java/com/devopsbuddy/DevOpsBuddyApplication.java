package com.devopsbuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.devopsbuddy.backend.persistance.repositories")
public class DevOpsBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevOpsBuddyApplication.class, args);
	}
}
