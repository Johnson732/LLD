package com.lld.systemdesign.creational.abstractfactory;

/**
 * Windows-specific checkbox
 */
public class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Windows checkbox");
    }
}