package com.epf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//toute la configuration de Spring est dans cette classe.
@SpringBootApplication
@ComponentScan(basePackages = {"com.epf.Controleur", "com.epf.Service", "com.epf.Persistance"})
public class Main extends SpringBootServletInitializer {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
