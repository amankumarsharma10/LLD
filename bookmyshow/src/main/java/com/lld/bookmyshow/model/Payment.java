package com.lld.bookmyshow.model;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private Double amount;
    private PaymentStatus status;
    private LocalDateTime paymentTime;
    private String transactionId;

    public Payment(String paymentId, PaymentStatus status, Double amount) {
        this.paymentId = paymentId;
        this.status = status;
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
