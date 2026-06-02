package com.lld.systemdesign.structural.decorator;

/**
 * Base notification implementation.
 *
 * Real-world idea:
 * An application sends notifications through email.
 */
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}