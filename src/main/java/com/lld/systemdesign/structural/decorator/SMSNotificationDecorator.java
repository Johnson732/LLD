package com.lld.systemdesign.structural.decorator;

/**
 * Adds SMS notification capability.
 */
public class SMSNotificationDecorator extends NotificationDecorator {

    public SMSNotificationDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("Sending SMS: " + message);
    }
}