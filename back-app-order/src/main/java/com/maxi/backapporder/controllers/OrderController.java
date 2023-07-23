package com.maxi.backapporder.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.backapporder.dtos.OrderDTO;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(value = "/total/{id}")
    public ResponseEntity<?> getTotal(@PathVariable Long id){
        Double val = orderService.getTotalOrder(id);
        return ResponseEntity.ok().body(val);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> create(@Valid @RequestBody OrderDTO obj) {
        Order order = orderService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

     @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody OrderDTO obj) {
        Order order = orderService.update(id, obj);
        return ResponseEntity.ok().body(order);
    }
}
