package com.dentistaclean.dentista.controllers.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentistaclean.dentista.model.entities.User;
import com.dentistaclean.dentista.model.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

	@Autowired
	UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<User>> listAll() {
		
		List<User> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		Optional<User> u = repository.findById(id);
		
		return ResponseEntity.ok().body(u.get());
		
	}
}
