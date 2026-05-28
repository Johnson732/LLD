package com.lld.systemdesign.creational.factory;

/**
 * Concrete implementation for SMS notifications.
 */
public class SmsNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}