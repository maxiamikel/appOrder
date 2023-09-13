package com.maxi.backapporder.enums;

public enum PaymentStatus {
    CANCEL("Cancel"),
    OK("Ok");

    private String paymentStatus;

    private PaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
