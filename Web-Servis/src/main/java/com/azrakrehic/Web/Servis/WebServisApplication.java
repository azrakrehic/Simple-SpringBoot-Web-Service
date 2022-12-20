package com.azrakrehic.Web.Servis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WebServisApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServisApplication.class, args);
	}

}
