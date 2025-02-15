package org.restapi.quote_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Quote Manager", version = "1.0", description = "Quote Manager API", 
					contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))
public class QuoteManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteManagerApplication.class, args);
	}

}
