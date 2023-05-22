package com.dentistaclean.dentista.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentistaclean.dentista.model.entities.Order;

public interface OrderRepository  extends JpaRepository<Order, Long> {

}
