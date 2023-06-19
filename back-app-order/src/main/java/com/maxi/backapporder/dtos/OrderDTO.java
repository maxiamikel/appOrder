package com.maxi.backapporder.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.enums.OrderStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OrderDTO {

    private Long id;

    @JsonFormat(pattern = "dd/mm/yyy HH:mm")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public OrderDTO() {
    }

    public OrderDTO(Order obj) {
        this.id = obj.getId();
        this.orderDate = obj.getOrderDate();
        this.status = obj.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
