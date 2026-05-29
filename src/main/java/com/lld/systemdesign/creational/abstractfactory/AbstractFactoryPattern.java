package com.lld.systemdesign.creational.abstractfactory;

/**
 * Abstract Factory example
 */
public final class AbstractFactoryPattern {

    private AbstractFactoryPattern() {
    }

    public static void main(String[] args) {

        // Imagine application configuration decides which factory to use
        GUIFactory factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();

        System.out.println("All factory UI components belong to the windows");

        GUIFactory factory2 = new MacFactory();

        Button button2 = factory2.createButton();
        Checkbox checkbox2 = factory2.createCheckbox();

        button2.render();
        checkbox2.render();

        System.out.println("All factory2 UI components belong to the Mac");
    }
}