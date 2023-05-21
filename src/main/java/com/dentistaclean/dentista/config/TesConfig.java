package com.dentistaclean.dentista.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dentistaclean.dentista.model.entities.User;
import com.dentistaclean.dentista.model.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Elizabeh Conceição", "elizabethcsouza@gmail.com", "986646485", "Gerais1234");
		User u2 = new User(null, "Mirelle Santana", "mirelle.santana@gmail.com", "986646400", "Gerais1234");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		
	}

}
