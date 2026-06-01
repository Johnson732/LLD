package com.lld.systemdesign.structural.adapter;

/**
 * Simulates a third-party or legacy payment gateway.
 */
public class LegacyPaymentGateway {

    public void makePayment(double amount) {
        System.out.println("Legacy Gateway processed payment of Rs. " + amount);
    }
}