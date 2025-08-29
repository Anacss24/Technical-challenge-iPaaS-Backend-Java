package com.technical_challenge.Internal.task.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InternalTaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalTaskManagementApplication.class, args);
	}

}
