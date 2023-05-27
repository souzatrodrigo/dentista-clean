package com.dentistaclean.dentista.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dentistaclean.dentista.model.entities.User;
import com.dentistaclean.dentista.model.repositories.UserRepository;
import com.dentistaclean.dentista.model.services.exceptions.DatabaseException;
import com.dentistaclean.dentista.model.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(Long id) {

		Optional<User> user = repository.findById(id);

		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<User> listAll() {

		List<User> list = repository.findAll();

		return list;
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		
		User user = findById(id);
		
		try {
			repository.delete(user);
		
		} catch(DataIntegrityViolationException e) {
			 throw new DatabaseException(e.getMessage()); 
		}
		
	}

	public User update(User obj, Long id) {

		User user = findById(id);
		updateData(user, obj);

		return user;
	}

	private void updateData(User user, User obj) {

		if (obj != null) {
			user.setName(obj.getName());
			user.setEmail(obj.getEmail());
			user.setPhone(obj.getPhone());
		}
	}
	
}
