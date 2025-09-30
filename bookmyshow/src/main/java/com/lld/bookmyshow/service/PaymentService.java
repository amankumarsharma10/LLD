package com.lld.bookmyshow.service;

import com.lld.bookmyshow.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    private String paymentId;
    private Double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime paymentTime;
    private String transactionId;
    public PaymentService(String paymentId, Double amount, PaymentMethod method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
        this.paymentTime = LocalDateTime.now();
    }

    public Payment processPayment(double amount) {
        // Simulate payment processing
        try {
            Thread.sleep(1000); // Simulate network call

            // Random success/failure for demo
            boolean success = Math.random() > 0.1; // 90% success rate

            if (success) {
                status = PaymentStatus.SUCCESS;
                transactionId = "TXN_" + System.currentTimeMillis();
            } else {
                status = PaymentStatus.FAILED;
            }

            return new Payment("paymentId",PaymentStatus.SUCCESS,amount);
        } catch (InterruptedException e) {
            status = PaymentStatus.FAILED;
            return new Payment("paymentId",PaymentStatus.FAILED,amount);
        }
    }

    public boolean refund() {
        if (status == PaymentStatus.SUCCESS) {
            status = PaymentStatus.REFUNDED;
            return true;
        }
        return false;
    }
}
