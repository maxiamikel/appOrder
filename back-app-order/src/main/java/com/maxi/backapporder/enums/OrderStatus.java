package com.maxi.backapporder.enums;

public enum OrderStatus {
    WAITTING("Waitting"),
    PAID("Paid"),
    CANCELED("Canceled"),
    VELIVERED("Delivered");

    private String orderStatus;

    private OrderStatus(String orderStatus){
        this.orderStatus= orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

}
