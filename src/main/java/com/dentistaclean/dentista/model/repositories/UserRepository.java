package com.dentistaclean.dentista.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentistaclean.dentista.model.entities.User;

public interface UserRepository  extends JpaRepository<User, Long> {

}
