package com.elhaouari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SbGestionCompteBanqueAngularApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SbGestionCompteBanqueAngularApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SbGestionCompteBanqueAngularApplication.class, args);
	}
}
