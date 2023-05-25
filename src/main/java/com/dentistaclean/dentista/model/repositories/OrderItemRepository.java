package com.dentistaclean.dentista.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentistaclean.dentista.model.entities.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long> {

}
