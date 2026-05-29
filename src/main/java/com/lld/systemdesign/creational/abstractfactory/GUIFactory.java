package com.lld.systemdesign.creational.abstractfactory;

/**
 * Factory responsible for creating related UI components
 */
public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
