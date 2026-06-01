package com.lld.systemdesign.structural.adapter;

/**
 * Adapter that converts the legacy payment gateway
 * into the interface expected by the application.
 */
public class PaymentGatewayAdapter implements PaymentProcessor {

    private final LegacyPaymentGateway legacyGateway;

    public PaymentGatewayAdapter(LegacyPaymentGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public void processPayment(double amount) {
        legacyGateway.makePayment(amount);
    }
}