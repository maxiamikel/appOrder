package com.maxi.backapporder.dtos;

import com.maxi.backapporder.entities.User;

public class UserDtoEdit {
    
    private Long id;

    private String name;
    private String cpf;
    private String email;
    private String matricule;
    private String telephone;

    public UserDtoEdit() {
    }

    public UserDtoEdit(User obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.matricule = obj.getMatricule();
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
