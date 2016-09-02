package com.exercise.organizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class OrganizerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OrganizerApplication.class);
	}
	
	public static void main(String[] args) {
		
		String s = "";
		SpringApplication.run(OrganizerApplication.class, args);
	}
	
	
}
