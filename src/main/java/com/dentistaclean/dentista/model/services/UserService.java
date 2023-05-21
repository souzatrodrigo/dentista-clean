package com.dentistaclean.dentista.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentistaclean.dentista.model.entities.User;
import com.dentistaclean.dentista.model.repositories.UserRepository;

@Service     
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findById(Long id) {
		
		Optional<User> user = repository.findById(id);
		
		return user.get();
	}
	
	public List<User> listAll(){
		
		List<User> list = repository.findAll();
		
		return list;
	}
	

}
