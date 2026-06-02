package com.lld.systemdesign.structural.decorator;

/**
 * Decorator Pattern example
 */
public final class DecoratorPattern {

    private DecoratorPattern() {
    }

    public static void main(String[] args) {

        Notification notification =
                new SlackNotificationDecorator(
                        new SMSNotificationDecorator(
                                new EmailNotification()));

        notification.send("Order has been shipped");
    }
}

/*
Output

Sending Email: Order has been shipped
Sending SMS: Order has been shipped
Sending Slack Message: Order has been shipped


 */