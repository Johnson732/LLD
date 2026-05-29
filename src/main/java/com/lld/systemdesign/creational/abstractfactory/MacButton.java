package com.lld.systemdesign.creational.abstractfactory;

/**
 * Mac-specific button
 */
public class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Mac button");
    }
}
