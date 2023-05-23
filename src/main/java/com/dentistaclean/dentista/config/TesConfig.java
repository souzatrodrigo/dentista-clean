package com.dentistaclean.dentista.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dentistaclean.dentista.model.entities.Category;
import com.dentistaclean.dentista.model.entities.Order;
import com.dentistaclean.dentista.model.entities.User;
import com.dentistaclean.dentista.model.entities.enuns.OrderStatus;
import com.dentistaclean.dentista.model.repositories.CategoryRepository;
import com.dentistaclean.dentista.model.repositories.OrderRepository;
import com.dentistaclean.dentista.model.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Elizabeh Conceição", "elizabethcsouza@gmail.com", "986646485", "Gerais1234");
		User u2 = new User(null, "Mirelle Santana", "mirelle.santana@gmail.com", "986646400", "Gerais1234");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u2, OrderStatus.CANCELED);
		orderRepository.saveAll(Arrays.asList(o1));
		
		Category cat1 = new Category(null, "Eleetrodomestico");
		Category cat2 = new Category(null, "Tecnologia");
		Category cat3 = new Category(null, "Computadores");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
	}

}
