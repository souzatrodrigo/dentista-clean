package com.dentistaclean.dentista.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dentistaclean.dentista.model.entities.Category;
import com.dentistaclean.dentista.model.entities.Order;
import com.dentistaclean.dentista.model.entities.OrderItem;
import com.dentistaclean.dentista.model.entities.Payment;
import com.dentistaclean.dentista.model.entities.Product;
import com.dentistaclean.dentista.model.entities.User;
import com.dentistaclean.dentista.model.entities.enuns.OrderStatus;
import com.dentistaclean.dentista.model.repositories.CategoryRepository;
import com.dentistaclean.dentista.model.repositories.OrderItemRepository;
import com.dentistaclean.dentista.model.repositories.OrderRepository;
import com.dentistaclean.dentista.model.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository itemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Elizabeh Conceição", "elizabethcsouza@gmail.com", "986646485", "Gerais1234");
		User u2 = new User(null, "Mirelle Santana", "mirelle.santana@gmail.com", "986646400", "Gerais1234");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2023-05-20T19:53:07Z"), u2, OrderStatus.CANCELED);
		Order o2 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), u2, OrderStatus.DELIVERED);
		Order o3 = new Order(null, Instant.parse("2021-07-20T19:53:07Z"), u2, OrderStatus.PAID);
		Order o4 = new Order(null, Instant.parse("2023-12-20T19:53:07Z"), u2, OrderStatus.DELIVERED);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		
		Category cat1 = new Category(null, "Eleetrodomestico");
		Category cat2 = new Category(null, "Tecnologia");
		Category cat3 = new Category(null, "Computadores");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "Acer 16Gb120G", "Notebook", 1850.0, null);
		Product p2 = new Product(null, "Asus 32Gb500Gb", "Notebook hightec", 3690.99, null);
		Product p3 = new Product(null, "Fone de ouvido samsung A1", "Fone de ouvido original celular samsung", 17.99, null);
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		OrderItem oi1 = new OrderItem(p1, o4, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(p3, o4, 3, p1.getPrice());
		OrderItem oi3 = new OrderItem(p2, o3, 5, p2.getPrice());
		
		itemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
		
		Payment pay1 = new Payment(null, Instant.parse("2021-07-20T21:53:07Z"), o3);
		
		o3.setPayment(pay1);
		orderRepository.save(o3);
		
	}

}
