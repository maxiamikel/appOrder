package com.maxi.backapporder.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.dtos.OrderDTO;
import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.repositories.OrderRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientService clientService;

   public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado: "+ Order.class.getSimpleName()));
    } 

      public Page<Order> findAll() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("id").ascending());
        return orderRepository.findAll(pageable);
    }
    
    public Order create(OrderDTO obj) {
        Client client = clientService.findById(obj.getClient().getId());
        Order newOrder = new Order(null, client);
        newOrder = orderRepository.saveAndFlush(newOrder);
        return newOrder;
    }

     public Order update(Long id, OrderDTO obj) {
        Order order = findById(id);
        order.setStatus(obj.getStatus());
        order.setModifyDate(LocalDateTime.now());
        return orderRepository.saveAndFlush(order);
    }

    public String finalizeOrder(Long id){
        Order obj = findById(id);
        return obj.getStatus().toString();
    }

    public Double getTotalOrder(Long id){
        Order obj = findById(id);
        Double total = obj.getTotal();
        return total;
    }
}
