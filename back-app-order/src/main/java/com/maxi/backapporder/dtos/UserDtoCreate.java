package com.maxi.backapporder.dtos;

import com.maxi.backapporder.entities.User;

public class UserDtoCreate {

    private Long id;

    private String name;
    private String cpf;
    private String email;
    //private String matricule;
    private String telephone;

    public UserDtoCreate() {
    }

    public UserDtoCreate(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        //this.matricule = obj.getMatricule();
        this.telephone = obj.getTelephone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
