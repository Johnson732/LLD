package com.lld.systemdesign.structural.decorator;

/**
 * Adds Slack notification capability.
 */
public class SlackNotificationDecorator extends NotificationDecorator {

    public SlackNotificationDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        notification.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}