package com.lld.systemdesign.structural.facade;

/**
 * Facade Pattern Example
 */
public final class FacadePattern {

    private FacadePattern() {
    }

    public static void main(String[] args) {

        OrderFacade orderFacade = new OrderFacade();

        orderFacade.placeOrder("johnson", 76423.00);
    }
}