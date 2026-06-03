package com.lld.systemdesign.structural.facade;

public class PaymentService {

    public void processPayment(double amount) {
        System.out.println("Processing payment: ₹" + amount);
    }
}