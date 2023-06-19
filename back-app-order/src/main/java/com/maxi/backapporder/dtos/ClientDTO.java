package com.maxi.backapporder.dtos;

import com.maxi.backapporder.entities.Client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "Campo nome requerido")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Campo email requerido")
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
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

}
