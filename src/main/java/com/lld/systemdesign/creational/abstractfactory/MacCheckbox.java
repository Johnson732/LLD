package com.lld.systemdesign.creational.abstractfactory;

/**
 * Mac-specific checkbox
 */
public class MacCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Mac checkbox");
    }
}
