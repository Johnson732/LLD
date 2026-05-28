package com.lld.systemdesign.creational.factory;

/**
 * Factory Pattern example
 */
public final class FactoryPattern {

    private FactoryPattern() {
    }

    public static void main(String[] args) {

        Notification emailNotification =
                NotificationFactory.createNotification("email");

        Notification smsNotification =
                NotificationFactory.createNotification("sms");

        emailNotification.send("Welcome user!");
        smsNotification.send("Your OTP is 4821");
    }
}