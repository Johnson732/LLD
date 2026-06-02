# Decorator Pattern

## 1. The problem it solves

Decorator solves the problem of adding behavior to an object dynamically without modifying its existing code.

Sometimes we start with a simple object and later need additional features.

If we keep creating subclasses for every possible combination, the number of classes grows quickly.

Example:

- Email Notification
- Email + SMS Notification
- Email + Slack Notification
- Email + SMS + Slack Notification

This becomes difficult to maintain.

Decorator allows us to add functionality by wrapping an object with another object.

## 2. When to use it

Use Decorator when:

- functionality needs to be added dynamically
- multiple combinations of behavior are possible
- subclass explosion should be avoided
- behavior should be reusable

Use cases:

- notification systems
- logging frameworks
- input/output streams
- security filters
- caching layers

Avoid Decorator when:

- behavior never changes
- simple inheritance is enough
- excessive wrapping makes the design hard to understand

## 3. Real-world engineering examples

### Example: Notification System

Imagine an e-commerce application.

Initially, users receive only email notifications.

Later requirements arrive:

- send SMS notifications
- send Slack notifications
- send both SMS and Slack notifications

Without Decorator, we might create:

- EmailNotification
- EmailAndSMSNotification
- EmailAndSlackNotification
- EmailSMSAndSlackNotification

The number of classes grows as requirements increase.

Decorator solves this by wrapping objects.

Example:

```java
Notification notification =
        new SlackNotificationDecorator(
                new SMSNotificationDecorator(
                        new EmailNotification()));
```

The notification is sent through:

1. Email
2. SMS
3. Slack

without changing the original EmailNotification class.

Other good real-world examples:

- Java I/O Streams
- Spring Security Filters
- Request/Response Middleware
- Logging Wrappers

## 4. Practical implementation insights

Important points to mention in interviews:

- start with a common interface
- create a concrete implementation
- create a base decorator that implements the same interface
- decorators wrap existing objects
- decorators can be combined in any order

For interview explanation:

1. Component Interface
2. Concrete Component
3. Base Decorator
4. Concrete Decorators

## Code walkthrough

### Notification.java

The common interface.

Every notification implementation follows this contract.

### EmailNotification.java

The base notification implementation.

This is the original object we want to enhance.

### NotificationDecorator.java

Abstract decorator class.

Stores a reference to another Notification object.

### SMSNotificationDecorator.java

Adds SMS notification behavior.

Calls the wrapped object first, then sends SMS.

### SlackNotificationDecorator.java

Adds Slack notification behavior.

Calls the wrapped object first, then sends Slack notification.

### DecoratorPattern.java

Demonstrates how decorators are combined.

The notification object is wrapped multiple times.

Each wrapper adds extra behavior while preserving the original behavior.

## Interview answer in one line

"Decorator allows behavior to be added to an object dynamically by wrapping it with decorator objects instead of modifying the original class."

## What to say if the interviewer asks follow-up questions

### 1. Decorator vs Inheritance?

Inheritance adds behavior at compile time.

Decorator adds behavior at runtime.

Decorator is more flexible.

### 2. What is the biggest advantage?

It follows the Open/Closed Principle.

We can extend behavior without modifying existing code.

### 3. Can multiple decorators be combined?

Yes.

That is one of the biggest strengths of the pattern.

```java
new SlackNotificationDecorator(
        new SMSNotificationDecorator(
                new EmailNotification()));
```

Each decorator adds new functionality.

### 4. Real Java example?

Java I/O Streams.

Examples:

- FileInputStream
- BufferedInputStream
- DataInputStream

These wrap each other and add extra functionality.

### 5. What are the disadvantages?

- many small classes
- object chains become harder to debug
- excessive decoration can reduce readability

### 6. Which SOLID principle does Decorator support?

Primarily:

Open/Closed Principle (OCP)

because behavior can be extended without changing existing classes.