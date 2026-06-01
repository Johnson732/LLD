package com.lld.systemdesign.structural.adapter;

/**
 * Modern payment interface expected by the application.
 */
public interface PaymentProcessor {

    void processPayment(double amount);
}