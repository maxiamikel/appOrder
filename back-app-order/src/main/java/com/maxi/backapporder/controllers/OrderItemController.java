package com.maxi.backapporder.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.backapporder.dtos.OrderItemDTO;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.services.OrderItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable  Long id){
        OrderItem obj = orderItemService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

     @GetMapping("/")
    public ResponseEntity<?> getListItems(){
        List<?> list = orderItemService.getListItems();
        return ResponseEntity.ok().body(list);
    }
    
    @PostMapping(value = "/new")
    public ResponseEntity<?> create(@Valid @RequestBody OrderItemDTO obj){
        OrderItem newObj = orderItemService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }
}
