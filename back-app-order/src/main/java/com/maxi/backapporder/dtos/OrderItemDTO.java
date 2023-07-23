package com.maxi.backapporder.dtos;

import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.entities.Product;

public class OrderItemDTO {

    private Long id;

    private Integer quantity;
    private Double price;

    private Product product;

    private Order order;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem obj) {
        this.id = obj.getId();
        this.quantity = obj.getQuantity();
        this.price = obj.getProduct().getPrice();
        this.product = obj.getProduct();
        this.order = obj.getOrder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
