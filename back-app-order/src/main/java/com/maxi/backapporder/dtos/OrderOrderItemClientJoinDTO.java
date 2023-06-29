package com.maxi.backapporder.dtos;

import java.time.LocalDateTime;

import com.maxi.backapporder.projections.OrderOrderItemClientJoin;

public class OrderOrderItemClientJoinDTO {
    private Long id;
    private String nome;
    private String email;
    private LocalDateTime orderDate;
    private String status;
    private String client;
    private Double total;

    public OrderOrderItemClientJoinDTO() {
    }

    public OrderOrderItemClientJoinDTO(OrderOrderItemClientJoin obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.orderDate = obj.getOrderDate();
        this.status = obj.getStatus();
        this.client = obj.getClient();
        this.total = obj.getTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
