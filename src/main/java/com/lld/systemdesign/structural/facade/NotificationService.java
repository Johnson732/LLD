package com.lld.systemdesign.structural.facade;

public class NotificationService {

    public void sendOrderConfirmation(String userId) {
        System.out.println("Sending order confirmation to user: " + userId);
    }
}