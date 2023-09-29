package com.naical.controlpane;

import com.naical.controlpane.auth.AuthenticationService;
import com.naical.controlpane.auth.RegisterRequest;
import com.naical.controlpane.role.Role;
import com.naical.controlpane.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ControlPaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlPaneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository ){
		return args -> {

			System.out.println(userRepository.findByFirstNameAndLastName("Mihaela", "Elena").getEmail());

		};
	}



}
