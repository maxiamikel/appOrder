package com.maxi.backapporder.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.backapporder.dtos.PaymentCreateDTO;
import com.maxi.backapporder.entities.Payment;
import com.maxi.backapporder.services.PaymentService;

@RestController
@RequestMapping(value = "/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Payment obj = paymentService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll(){
        Page<Payment> page = paymentService.findAll();
        return ResponseEntity.ok().body(page);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody PaymentCreateDTO obj){
        Payment payment = paymentService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(payment);
    }
    
}
