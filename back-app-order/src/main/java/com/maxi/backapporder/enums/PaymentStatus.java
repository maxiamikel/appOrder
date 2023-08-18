package com.maxi.backapporder.enums;

public enum PaymentStatus {
    PENDING("Pending"),
    PAID("Paid");

    private String paymentStatus;

    private PaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
