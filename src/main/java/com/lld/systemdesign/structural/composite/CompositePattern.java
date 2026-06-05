package com.lld.systemdesign.structural.composite;

/**
 * Composite Pattern Example
 */
public final class CompositePattern {

    private CompositePattern() {
    }

    public static void main(String[] args) {

        Server authServer = new Server("Auth-Service");
        Server paymentServer = new Server("Payment-Service");
        Server userServer = new Server("User-Service");

        InfrastructureGroup backendCluster =
                new InfrastructureGroup("Backend Cluster");

        backendCluster.add(authServer);
        backendCluster.add(paymentServer);
        backendCluster.add(userServer);

        Server nginxServer = new Server("Nginx");

        InfrastructureGroup productionEnvironment =
                new InfrastructureGroup("Production Environment");

        productionEnvironment.add(nginxServer);
        productionEnvironment.add(backendCluster);

        productionEnvironment.showStatus();
    }
}