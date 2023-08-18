package com.maxi.backapporder.enums;

public enum OrderStatus {
    WAITTING("Waitting"),
    PROCESSING("Processing"),
    CANCELED("Canceled"),
    DELIVERED("Delivered");

    private String orderStatus;

    private OrderStatus(String orderStatus){
        this.orderStatus= orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

}
