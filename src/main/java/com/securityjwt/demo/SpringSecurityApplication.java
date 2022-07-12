package com.securityjwt.demo;

import com.securityjwt.demo.model.Role;
import com.securityjwt.demo.model.User;
import com.securityjwt.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		System.out.println("Running spring");
	}

	@Bean
	CommandLineRunner runner (UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Gonzalo zoloaga","gonza","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"Pepe sand","pepe","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"Pedroo sand","pedro","12345",new ArrayList<>()));
			userService.saveUser(new User(null,"Franco zoloaga","franco","12345",new ArrayList<>()));

			userService.addRoleToUser("gonza","ROLE_ADMIN");
			userService.addRoleToUser("gonza","ROLE_MANAGER");
			userService.addRoleToUser("pepe","ROLE_USER");
			userService.addRoleToUser("franco","ROLE_MANAGER");

		};
	}

}
