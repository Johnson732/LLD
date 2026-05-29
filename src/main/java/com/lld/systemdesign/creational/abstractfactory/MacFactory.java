package com.lld.systemdesign.creational.abstractfactory;

/**
 * Creates Mac UI components
 */
public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
