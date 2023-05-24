package com.dentistaclean.dentista.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentistaclean.dentista.model.entities.Product;
import com.dentistaclean.dentista.model.repositories.ProductRepository;

@Service     
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product findById(Long id) {
		
		Optional<Product> Product = repository.findById(id);
		
		return Product.get();
	}
	
	public List<Product> listAll(){
		
		List<Product> list = repository.findAll();
		
		return list;
	}
	

}
