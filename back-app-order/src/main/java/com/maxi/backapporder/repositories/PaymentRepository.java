package com.maxi.backapporder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.backapporder.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p")
    List<Payment> findALl();

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.order=: orderId")
    double findSumAmount(Long orderId);
}
