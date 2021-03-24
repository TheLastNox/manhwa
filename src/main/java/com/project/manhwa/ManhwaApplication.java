package com.project.manhwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("controller")
@EntityScan("model")
@EnableJpaRepositories("dao")
public class ManhwaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManhwaApplication.class, args);
	}

}
