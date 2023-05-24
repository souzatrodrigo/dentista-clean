package com.dentistaclean.dentista.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentistaclean.dentista.model.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
