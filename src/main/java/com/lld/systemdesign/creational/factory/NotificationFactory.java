package com.lld.systemdesign.creational.factory;

/**
 * Factory class responsible for object creation.
 */
public final class NotificationFactory {

    private NotificationFactory() {
    }

    public static Notification createNotification(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Notification type cannot be empty");
        }

        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Unsupported notification type: " + type);
        };
    }
}