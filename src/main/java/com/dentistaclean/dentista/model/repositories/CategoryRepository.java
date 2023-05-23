package com.dentistaclean.dentista.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentistaclean.dentista.model.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}
