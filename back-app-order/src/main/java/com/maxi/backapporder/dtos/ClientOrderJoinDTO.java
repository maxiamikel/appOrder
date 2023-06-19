package com.maxi.backapporder.dtos;


import java.time.LocalDate;

import com.maxi.backapporder.projections.ClientOrderJoin;

public class ClientOrderJoinDTO {
    private String nome;
    private String email;
    private String status;
    private LocalDate orderDate;

    public ClientOrderJoinDTO() {
        super();
    }

    public ClientOrderJoinDTO(ClientOrderJoin obj) {
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.status = obj.getStatus();
        this.orderDate = obj.getOrderDate();
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
        
}

