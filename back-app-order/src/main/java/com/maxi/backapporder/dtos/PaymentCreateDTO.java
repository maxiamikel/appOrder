package com.maxi.backapporder.dtos;

import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.Payment;

public class PaymentCreateDTO {
    
    private Long id;
    private Order order;
    private double amount;
    public PaymentCreateDTO() {
    }
    public PaymentCreateDTO(Payment obj) {
        this.id = obj.getId();
        this.order = obj.getOrder();
        this.amount = obj.getAmount();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
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

    
}
