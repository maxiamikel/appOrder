package com.maxi.backapporder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.services.OrderItemService;

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
    
}
