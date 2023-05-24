package com.dentistaclean.dentista.controllers.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentistaclean.dentista.model.entities.Product;
import com.dentistaclean.dentista.model.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> listAll() {
		
		List<Product> list = service.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product u = service.findById(id);
		
		return ResponseEntity.ok().body(u);
		
	}
}
