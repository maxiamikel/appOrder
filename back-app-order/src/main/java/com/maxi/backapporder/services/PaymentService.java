package com.maxi.backapporder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.dtos.PaymentCreateDTO;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.Payment;
import com.maxi.backapporder.enums.PaymentStatus;
import com.maxi.backapporder.repositories.PaymentRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderService orderService;

    public Payment findById(Long id){
        Optional<Payment> obj = paymentRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado"));
    }

    public Page<Payment> findAll(){
        Pageable pageable = PageRequest.of(0, 5);
        return paymentRepository.findAll(pageable);
    }

    public Payment create(PaymentCreateDTO obj){
        Order order = orderService.findById(obj.getOrder().getId());
        Payment payment = new Payment(null, order, obj.getAmount());
        payment.setPaymentStatus(PaymentStatus.PAID);
        return paymentRepository.save(payment);
    }
    
    public double findSumAmount(Long id){
        double total = paymentRepository.findSumAmount(id);
        return total;
    }
}
