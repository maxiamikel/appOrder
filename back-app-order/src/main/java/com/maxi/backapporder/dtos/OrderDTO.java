package com.maxi.backapporder.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.enums.OrderStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OrderDTO {

    private Long id;

    @JsonFormat(pattern = "dd/mm/yyy HH:mm")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items;

    public OrderDTO() {
    }

    public OrderDTO(Order obj) {
        this.id = obj.getId();
        this.status = obj.getStatus();
        this.client = obj.getClient();
        this.items = obj.getItems();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

}
