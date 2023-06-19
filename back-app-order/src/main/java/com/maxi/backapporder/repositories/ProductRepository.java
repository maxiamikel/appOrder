package com.maxi.backapporder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backapporder.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
