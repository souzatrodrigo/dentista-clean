package com.dentistaclean.dentista.controllers.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentistaclean.dentista.model.entities.Order;
import com.dentistaclean.dentista.model.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> listAll() {
		
		List<Order> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order u = service.findById(id);
		
		return ResponseEntity.ok().body(u);
		
	}
}
