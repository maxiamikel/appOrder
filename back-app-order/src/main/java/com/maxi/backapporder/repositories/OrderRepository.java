package com.maxi.backapporder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backapporder.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
