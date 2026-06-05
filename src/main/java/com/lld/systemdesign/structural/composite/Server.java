package com.lld.systemdesign.structural.composite;

/**
 * Leaf object.
 * Represents a single server.
 */
public class Server implements InfrastructureComponent {

    private final String serverName;

    public Server(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public void showStatus() {
        System.out.println("Server: " + serverName + " [RUNNING]");
    }
}