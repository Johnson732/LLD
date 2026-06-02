package com.lld.systemdesign.structural.decorator;

/**
 * Base decorator.
 */
public abstract class NotificationDecorator implements Notification {

    protected final Notification notification;

    protected NotificationDecorator(Notification notification) {
        this.notification = notification;
    }
}