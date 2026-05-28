package com.lld.systemdesign.creational.factory;

/**
 * Common contract for all notification types.
 */
public interface Notification {
    void send(String message);
}
