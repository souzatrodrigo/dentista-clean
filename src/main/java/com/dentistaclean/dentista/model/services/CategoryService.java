package com.dentistaclean.dentista.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentistaclean.dentista.model.entities.Category;
import com.dentistaclean.dentista.model.repositories.CategoryRepository;

@Service     
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Long id) {
		
		Optional<Category> Category = repository.findById(id);
		
		return Category.get();
	}
	
	public List<Category> listAll(){
		
		List<Category> list = repository.findAll();
		
		return list;
	}
	

}
