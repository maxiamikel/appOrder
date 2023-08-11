package com.maxi.backapporder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backapporder.entities.Login;
import com.maxi.backapporder.entities.User;

public interface LoginRepository extends JpaRepository<Login, Long>{
    User findByUsername(String username);
    
}
