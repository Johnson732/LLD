package com.lld.systemdesign.creational.factory;

/**
 * Concrete implementation for email notifications.
 */
public class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Sending EMAIL:" + message);
    }
}
