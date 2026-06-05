package com.lld.systemdesign.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite object.
 * Can contain both servers and other groups.
 */
public class InfrastructureGroup implements InfrastructureComponent {

    private final String groupName;
    private final List<InfrastructureComponent> components = new ArrayList<>();

    public InfrastructureGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(InfrastructureComponent component) {
        components.add(component);
    }

    public void remove(InfrastructureComponent component) {
        components.remove(component);
    }

    @Override
    public void showStatus() {
        System.out.println("\nInfrastructure Group: " + groupName);

        for (InfrastructureComponent component : components) {
            component.showStatus();
        }
    }
}