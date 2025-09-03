package com.project.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(           // For Swagger documentation
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "Bank Accounts microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Ritesh Gupta",
                        email = "ritesh.gupta.18117@gmail.com",
                        url = "https://www.linkedin.com/in/ritesh-kumar-gupta-3648ab187/"
                ),
                license = @License(
                        name = "License Name",
                        url = "https://www.linkedin.com/in/ritesh-kumar-gupta-3648ab187/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Bank Accounts microservice REST API Documentation",
                url = "https://www.linkedin.com/in/ritesh-kumar-gupta-3648ab187/"
        )
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
