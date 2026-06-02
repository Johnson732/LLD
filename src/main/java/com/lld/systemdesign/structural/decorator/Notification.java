package com.lld.systemdesign.structural.decorator;

/**
 * Common contract for all notification types.
 */
public interface Notification {

    void send(String message);
}