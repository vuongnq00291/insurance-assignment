package com.element.in;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Start rest application
 * @author vuong
 *
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
    	new SpringApplicationBuilder(Application.class)
        .properties("spring.config.name=application,data")
        .run(args);
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
