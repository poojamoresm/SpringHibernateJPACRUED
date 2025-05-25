package com.example.SpringHibernateJPACRUED;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateJpacruedApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringHibernateJpacruedApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(String[] args){
return runner->{

	System.out.println("Hello Word");
		};
	}
}
