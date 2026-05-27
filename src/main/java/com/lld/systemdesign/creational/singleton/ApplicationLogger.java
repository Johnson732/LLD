package com.lld.systemdesign.creational.singleton;

/**

 * Real-world idea:
 * An application usually needs one shared logger manager so every module follows
 * the same logging behavior.
 */
public final class ApplicationLogger {

    private static final ApplicationLogger INSTANCE = new ApplicationLogger();

    private ApplicationLogger() {
    }

    public static ApplicationLogger getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println("[APP-LOG] " + message);
    }
}
