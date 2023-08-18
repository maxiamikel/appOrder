package com.maxi.backapporder.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxi.backapporder.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Order order;
    private double amount;
    private LocalDate date;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public Payment() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.paymentStatus = PaymentStatus.PAID;
    }

    public Payment(Long id, Order order, double amount) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Order getOrder() {
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    

}
