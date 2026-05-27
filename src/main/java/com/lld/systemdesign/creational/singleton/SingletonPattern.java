package com.lld.systemdesign.creational.singleton;

/**
 * Singleton example
 */
public final class SingletonPattern {

    private SingletonPattern() {
    }

    public static void main(String[] args) {
        // Think of these as two different modules in the same application
        // trying to access the shared logger manager.
        ApplicationLogger loggerOne = ApplicationLogger.getInstance();
        ApplicationLogger loggerTwo = ApplicationLogger.getInstance();

        loggerOne.log("User service started");
        loggerTwo.log("Payment service started");

        System.out.println("Both references point to same object: " + (loggerOne == loggerTwo));
    }
}
