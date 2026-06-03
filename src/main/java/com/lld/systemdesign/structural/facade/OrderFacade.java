package com.lld.systemdesign.structural.facade;

/**
 * Facade that hides the complexity of
 * authentication, payment, and notification.
 */
public class OrderFacade {

    private final AuthService authService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.authService = new AuthService();
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(String userId, double amount) {

        if (!authService.authenticate(userId)) {
            throw new RuntimeException("Authentication failed");
        }

        paymentService.processPayment(amount);

        notificationService.sendOrderConfirmation(userId);

        System.out.println("Order placed successfully");
    }
}