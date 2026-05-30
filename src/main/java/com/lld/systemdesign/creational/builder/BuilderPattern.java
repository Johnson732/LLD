package com.lld.systemdesign.creational.builder;

/**
 * Builder Pattern example
 */
public final class BuilderPattern {

    private BuilderPattern() {
    }

    public static void main(String[] args) {

        ApiClient paymentClient = new ApiClient.Builder(
                "https://api.payment.com",
                "payment-api-key")
                .connectTimeout(3000)
                .readTimeout(8000)
                .retryCount(5)
                .loggingEnabled(true)
                .build();

        paymentClient.printConfiguration();

        System.out.println();

        ApiClient notificationClient = new ApiClient.Builder(
                "https://api.notification.com",
                "notification-api-key")
                .build();

        notificationClient.printConfiguration();
    }
}