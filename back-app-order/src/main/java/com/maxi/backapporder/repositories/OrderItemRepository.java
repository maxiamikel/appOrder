package com.maxi.backapporder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backapporder.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
