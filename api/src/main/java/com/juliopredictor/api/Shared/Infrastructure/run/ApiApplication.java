package com.juliopredictor.api.Shared.Infrastructure.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
//@EnableJpaRepositories("com.juliopredictor.api.Backoffice.Courses.Infrastructure.Repository")
//@EntityScan("dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
