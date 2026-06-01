package com.lld.systemdesign.structural.adapter;

/**
 * Adapter Pattern example.
 */
public final class AdapterPattern {

    private AdapterPattern() {
    }

    public static void main(String[] args) {

        LegacyPaymentGateway legacyGateway =
                new LegacyPaymentGateway();

        PaymentProcessor paymentProcessor =
                new PaymentGatewayAdapter(legacyGateway);

        paymentProcessor.processPayment(1500);
    }
}