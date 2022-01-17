package com.example.authenticationoverview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // to enable preAuthorize and postAUthorize
public class AuthenticationOverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationOverviewApplication.class, args);
	}

}
