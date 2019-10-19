package com.practice.boot.bootLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.practice.boot.config.SwaggerConfig;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@ComponentScan({ "com.practice.boot.*" })
public class BootLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootLearnApplication.class, args);
		
	}

}
