package com.maxi.backapporder.dtos;

import com.maxi.backapporder.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer stock;

    public ProductDTO() {
    }

    public ProductDTO(Product obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.stock = obj.getStock();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
