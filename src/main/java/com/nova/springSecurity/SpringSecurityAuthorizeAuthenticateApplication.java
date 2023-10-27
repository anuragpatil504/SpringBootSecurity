package com.nova.springSecurity;

import com.nova.springSecurity.models.ApplicationUser;
import com.nova.springSecurity.models.Role;
import com.nova.springSecurity.repository.RoleRepository;
import com.nova.springSecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAuthorizeAuthenticateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthorizeAuthenticateApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);
			userRepository.save(admin);
		};
	}

}
