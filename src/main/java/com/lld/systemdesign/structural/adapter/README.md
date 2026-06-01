# Adapter Pattern

## 1. The problem it solves

Adapter Pattern solves the problem of integrating classes with incompatible interfaces.

Sometimes an application expects one interface, but an existing or third-party class exposes a different interface.

Without Adapter:

- existing code cannot be used directly
- application code must be modified
- tight coupling increases

Adapter makes two incompatible components work together.

Think of it as a translator between two systems.

---

## 2. When to use it

Use Adapter when:

- you want to reuse existing code
- a third-party library exposes a different interface
- a legacy system must work with a modern application
- modifying existing code is difficult or impossible

Avoid Adapter when:

- both systems already share the same interface
- creating a common abstraction is easier

---

## 3. Real-world engineering example

### Example: Payment Gateway Integration

Suppose your application expects every payment provider to implement:

```java
processPayment(amount);
```

But an old payment gateway provides:

```java
makePayment(amount);
```

The method names are different.

Instead of changing application code everywhere, we create an Adapter.

The Adapter converts:

```java
processPayment()
```

into

```java
makePayment()
```

allowing the old gateway to work with the new system.

---

## 4. Practical implementation insights

Adapter consists of three main parts:

### Target

The interface expected by the client.

Example:

```java
PaymentProcessor
```

### Adaptee

The existing class with an incompatible interface.

Example:

```java
LegacyPaymentGateway
```

### Adapter

The bridge between them.

Example:

```java
PaymentGatewayAdapter
```

---

## Code walkthrough

### PaymentProcessor.java

Defines the interface expected by the application.

```java
processPayment()
```

All payment providers should implement this contract.

---

### LegacyPaymentGateway.java

Represents an existing system.

It already works but uses a different method:

```java
makePayment()
```

---

### PaymentGatewayAdapter.java

The core of the Adapter Pattern.

Responsibilities:

- implements PaymentProcessor
- wraps LegacyPaymentGateway
- translates requests

Internally:

```java
processPayment()
```

becomes

```java
makePayment()
```

---

### AdapterPattern.java

Demonstrates usage.

What it does:

1. Creates the legacy gateway.
2. Wraps it inside the adapter.
3. Uses it through the expected interface.

The client never knows a legacy class is being used.

---

## Interview answer in one line

"Adapter Pattern allows incompatible interfaces to work together by introducing a wrapper that translates one interface into another."

---

## What to say if the interviewer asks follow-up questions

### 1. Adapter vs Facade?

Adapter:

- converts one interface into another

Facade:

- provides a simplified interface to a complex subsystem

---

### 2. Adapter vs Decorator?

Adapter:

- changes the interface

Decorator:

- keeps the same interface and adds behavior

---

### 3. Real-world examples?

Examples include:

- payment gateway integration
- legacy API integration
- database driver wrappers
- external vendor SDK integration

---

### 4. Is Adapter a Structural Pattern?

Yes.

It focuses on how classes and objects are composed to form larger structures.

---

### 5. Can Adapter work with third-party libraries?

Yes.

This is one of the most common reasons for using Adapter.

It allows integration without modifying third-party code.

---

## Quick Analogy

Imagine a laptop with a USB-C port and a projector with an HDMI cable.

They cannot connect directly.

A USB-C to HDMI converter acts as the Adapter.

Laptop = Client

HDMI Projector = Adaptee

Converter = Adapter

The Adapter makes incompatible interfaces work together.