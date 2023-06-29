package com.maxi.backapporder.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.backapporder.dtos.ProductDTO;
import com.maxi.backapporder.entities.Product;
import com.maxi.backapporder.services.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll(){
        Page<Product>  page = productService.findAll();
        return ResponseEntity.ok().body(page);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> create(@RequestBody ProductDTO obj){
        Product newProduct = productService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(newProduct);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO obj){
        Product product = productService.update(id, obj);
        return ResponseEntity.ok().body(product);
    }
}
