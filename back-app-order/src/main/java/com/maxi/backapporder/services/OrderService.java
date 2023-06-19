package com.maxi.backapporder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.repositories.OrderRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

   public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado"));
    } 
    
}
