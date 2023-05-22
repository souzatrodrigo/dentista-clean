package com.dentistaclean.dentista.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentistaclean.dentista.model.entities.Order;
import com.dentistaclean.dentista.model.repositories.OrderRepository;

@Service     
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public Order findById(Long id) {
		
		Optional<Order> Order = repository.findById(id);
		
		return Order.get();
	}
	
	public List<Order> listAll(){
		
		List<Order> list = repository.findAll();
		
		return list;
	}
	

}
