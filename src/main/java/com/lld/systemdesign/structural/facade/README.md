# Facade Pattern

## 1. The problem it solves

Facade solves the problem of dealing with multiple complex subsystems directly.

Without a Facade, a client may need to:

- authenticate users
- process payments
- send notifications
- coordinate multiple service calls

This creates:

- tight coupling
- repetitive code
- difficult maintenance
- harder onboarding for new developers

Facade provides a simple interface that hides subsystem complexity.

## 2. When to use it

Use Facade when:

- a workflow requires multiple services
- clients should not know subsystem details
- you want a cleaner API
- you want to reduce coupling

Common examples:

- order processing
- payment gateways
- cloud deployment APIs
- media processing pipelines

Avoid Facade when:

- the subsystem is already simple
- clients need direct access to every subsystem feature

## 3. Real-world engineering examples

### Example: Order Processing System

In an e-commerce application, placing an order often requires:

1. User Authentication
2. Payment Processing
3. Notification Sending

Without Facade:

```java
AuthService authService = new AuthService();
PaymentService paymentService = new PaymentService();
NotificationService notificationService = new NotificationService();

authService.authenticate(userId);
paymentService.processPayment(amount);
notificationService.sendOrderConfirmation(userId);
```

Every client must know the workflow.

With Facade:

```java
OrderFacade facade = new OrderFacade();
facade.placeOrder(userId, amount);
```

The complexity is hidden.

## 4. Practical implementation insights

Important interview points:

- Facade simplifies interaction with complex subsystems.
- It does not add new functionality.
- It provides a unified interface.
- It reduces coupling between clients and subsystems.

Interview explanation:

1. Multiple subsystem classes exist.
2. Facade coordinates them.
3. Client interacts only with Facade.

## Code Walkthrough

### AuthService.java

Responsible for:

- user authentication
- security validation

### PaymentService.java

Responsible for:

- payment processing
- transaction handling

### NotificationService.java

Responsible for:

- sending notifications
- customer communication

### OrderFacade.java

Acts as the Facade.

Responsibilities:

- coordinate subsystem calls
- hide workflow complexity
- provide a simple API

### FacadePattern.java

Demo class showing how clients use the Facade.

The client only calls:

```java
orderFacade.placeOrder(...)
```

instead of interacting with multiple services directly.

## Interview answer in one line

"Facade provides a simplified interface to a set of complex subsystems, making them easier to use."

## What to say if the interviewer asks follow-up questions

### 1. Is Facade similar to Adapter?

No.

Adapter converts one interface into another.

Facade provides a simpler interface over existing subsystems.

### 2. Does Facade reduce functionality?

No.

It only simplifies access to existing functionality.

### 3. Can subsystems still be used directly?

Yes.

Facade is an additional convenience layer.

### 4. What is the biggest advantage?

Reduced complexity and lower coupling.

### 5. Real-world Java examples?

Examples include:

- JDBC helper libraries
- Spring's JdbcTemplate
- SLF4J logging abstraction
- AWS SDK service clients

### 6. Difference between Singleton and Facade?

Singleton focuses on:

- object creation
- ensuring one instance

Facade focuses on:

- simplifying subsystem interaction
- hiding complexity

Singleton = Creational Pattern

Facade = Structural Pattern