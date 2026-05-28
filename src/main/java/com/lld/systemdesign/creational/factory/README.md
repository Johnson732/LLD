# Factory Pattern

## 1. The problem it solves

Factory Pattern solves the problem of creating objects directly using `new`
everywhere in the application.

Without Factory Pattern:

- object creation logic gets scattered across the codebase
- code becomes tightly coupled to concrete classes
- changing object creation becomes difficult
- adding new types requires modifying many places

Factory Pattern centralizes object creation.

Instead of creating objects directly, we ask a factory to create them for us.

This helps:

- hide creation logic
- reduce coupling
- improve maintainability
- make code easier to extend

---

## 2. When to use it

Use Factory Pattern when:

- object creation logic is complex
- multiple implementations share a common interface
- the exact object type depends on input or conditions
- you want loose coupling between client code and implementations

Use cases:

- notification systems
- payment gateway selection
- database driver creation
- parser selection
- UI component creation

Avoid Factory Pattern when:

- object creation is extremely simple
- only one implementation exists permanently
- adding abstraction makes code unnecessarily complicated

---

## 3. Real-world engineering examples

### Example: `NotificationFactory`

In real applications, notifications can be sent in different ways:

- email
- SMS
- push notification
- WhatsApp notification

If every module directly creates these objects using `new`,
the application becomes tightly coupled to implementation classes.

Instead:

- modules ask the factory for a notification object
- factory decides which object to create
- client code only depends on the `Notification` interface

This makes the system easier to extend later.

For example:

- tomorrow we can add `PushNotification`
- existing client code will not change much

Other real-world examples:

- `PaymentGatewayFactory`
- `DatabaseConnectionFactory`
- `DocumentParserFactory`
- `UIWidgetFactory`

---

## 4. Practical implementation insights

Important points to mention in interviews:

- define a common interface or abstract class
- create multiple concrete implementations
- move object creation logic into a factory class
- client code should depend on abstractions, not concrete classes

For interview explanation, this is enough:

1. common interface
2. concrete implementations
3. factory class
4. client requests objects from factory

---

# Code walkthrough

## `Notification.java`

This is the common contract.

What it does:

- defines behavior shared by all notification types
- allows client code to work with abstractions

---

## `EmailNotification.java`

Concrete implementation for email notifications.

What it does:

- implements the `Notification` interface
- provides email-specific behavior

---

## `SmsNotification.java`

Concrete implementation for SMS notifications.

What it does:

- implements the `Notification` interface
- provides SMS-specific behavior

---

## `NotificationFactory.java`

This is the core factory class.

What it does:

- creates objects based on input type
- hides object creation logic from clients
- returns interface references instead of concrete classes

Why this is useful:

- client code becomes loosely coupled
- easier to add new notification types later

---

## `FactoryPattern.java`

This is the demo class.

What it does:

- requests notification objects from factory
- uses returned objects normally
- demonstrates how Factory Pattern works in practice

---

# Interview answer in one line

"Factory Pattern centralizes object creation and helps client code depend on abstractions instead of concrete implementations."

---

# What to say if the interviewer asks follow-up questions

## 1. What is the main advantage of Factory Pattern?

Answer:

It reduces tight coupling because client code does not directly create concrete objects.

---

## 2. How is Factory different from Singleton?

Short answer:

- Singleton controls object count
- Factory controls object creation

Singleton ensures only one object exists.

Factory decides which object to create.

---

## 3. Does Factory Pattern improve extensibility?

Answer:

Yes.

We can add new implementations with minimal changes to existing client code.

Example:

- add `PushNotification`
- update factory logic
- existing usage code remains mostly unchanged

---

## 4. What principle does Factory Pattern support?

Answer:

Factory Pattern supports:

- Open/Closed Principle
- Dependency Inversion Principle

because client code depends on abstractions instead of concrete classes.

---

## 5. What are common Factory Pattern variations?

You can mention:

- Simple Factory
- Factory Method
- Abstract Factory

Short answer:

"This example is a simple factory. More advanced factory patterns include Factory Method and Abstract Factory."

---

## 6. Is Factory Pattern heavily used in frameworks?

Answer:

Yes.

Frameworks like Spring use factory concepts internally for bean creation and dependency management.