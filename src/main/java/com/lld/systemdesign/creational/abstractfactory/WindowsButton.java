package com.lld.systemdesign.creational.abstractfactory;

/**
 * Windows-specific button
 */
public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Windows button");
    }
}