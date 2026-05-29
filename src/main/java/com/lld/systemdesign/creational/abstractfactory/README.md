# Abstract Factory Pattern

## 1. The problem it solves

Abstract Factory solves the problem of creating families of related objects without tightly coupling the client code to concrete classes.

Sometimes an application must support multiple related variants of objects.

Example:

* Windows UI components
* Mac UI components
* Linux UI components

If we directly create objects using `new`, the code becomes tightly coupled to specific implementations.

Problems with that approach:

* difficult to switch product families
* many `if-else` conditions
* hard-to-maintain object creation logic
* inconsistent object combinations

Abstract Factory solves this by:

* grouping related object creation together
* hiding concrete implementations
* ensuring compatible objects are used together

---

## 2. When to use it

Use Abstract Factory when:

* the system supports multiple product families
* objects are related and should work together
* you want to avoid direct dependency on concrete classes
* object creation logic is becoming complex

Use cases:

* cross-platform UI systems
* theme engines
* cloud provider SDKs
* database driver families

Avoid Abstract Factory when:

* there is only one product type
* the object creation logic is simple
* adding factories creates unnecessary complexity

---

## 3. Real-world engineering examples

### Example: Cross-platform UI framework

Suppose a desktop application supports:

* Windows UI
* Mac UI

Each platform needs its own:

* button
* checkbox
* text field
* dialog

We should not mix components like:

* Windows button + Mac checkbox

That creates inconsistent UI behavior.

Abstract Factory ensures:

* all created components belong to the same family
* UI remains consistent
* switching platforms becomes easy

That is why GUI systems are one of the most common Abstract Factory examples.

Other realistic examples:

* cloud providers (`AWSFactory`, `AzureFactory`)
* database connectors (`MySQLFactory`, `PostgresFactory`)
* payment gateway integrations
* operating-system-specific services

---

## 4. Practical implementation insights

Important interview points:

* define abstract product interfaces
* create concrete product implementations
* define an abstract factory interface
* create concrete factories for each product family
* client code depends only on abstractions

In this example:

### Abstract products

* `Button`
* `Checkbox`

### Concrete products

* `WindowsButton`
* `WindowsCheckbox`
* `MacButton`
* `MacCheckbox`

### Abstract factory

* `GUIFactory`

### Concrete factories

* `WindowsFactory`
* `MacFactory`

---

# Code walkthrough

## `Button.java` and `Checkbox.java`

These are product interfaces.

They define common behavior shared by all UI components.

The client code uses interfaces instead of concrete classes.

---

## `WindowsButton.java` and `MacButton.java`

These are concrete button implementations.

Each implementation represents platform-specific behavior.

---

## `WindowsCheckbox.java` and `MacCheckbox.java`

These are concrete checkbox implementations.

Again, behavior belongs to a specific UI family.

---

## `GUIFactory.java`

This is the central Abstract Factory interface.

It defines methods for creating related objects.

```java
Button createButton();

Checkbox createCheckbox();
```

The client code only knows about this abstraction.

---

## `WindowsFactory.java`

Creates Windows-specific UI components.

```java
return new WindowsButton();
return new WindowsCheckbox();
```

---

## `MacFactory.java`

Creates Mac-specific UI components.

```java
return new MacButton();
return new MacCheckbox();
```

---

## `AbstractFactoryPattern.java`

This is the demo class.

What it does:

* selects a factory
* creates related UI components
* uses products through interfaces

Most important idea:

The client code never directly creates concrete objects.

It only interacts with:

* `GUIFactory`
* `Button`
* `Checkbox`

This reduces coupling.

---

# Interview answer in one line

"Abstract Factory provides an interface for creating families of related objects without specifying their concrete classes."

---

# Difference between Factory Method and Abstract Factory

## Factory Method

Creates one product.

Example:

```java
Button createButton()
```

## Abstract Factory

Creates multiple related products.

Example:

```java
Button createButton();
Checkbox createCheckbox();
```

Short interview explanation:

"Factory Method focuses on creating a single product, while Abstract Factory creates families of related products."

---

# Advantages

* loose coupling
* consistent product families
* easy to switch implementations
* better scalability
* cleaner object creation

---

# Disadvantages

* adds more classes
* increases abstraction
* harder to understand initially
* adding new product types affects all factories

---

# Common interview follow-up questions

## 1. Why is it called “family of objects”?

Because the created objects are related and designed to work together.

Example:

* Windows button
* Windows checkbox
* Windows dialog

All belong to the Windows UI family.

---

## 2. How does Abstract Factory improve maintainability?

The client code depends on interfaces instead of concrete classes.

This makes it easier to replace implementations.

---

## 3. What SOLID principles does it support?

You can mention:

* Open/Closed Principle
* Dependency Inversion Principle

The client depends on abstractions, not implementations.

---

## 4. What is the biggest drawback?

Adding a new product type requires changing all factories.

For example:

If we add `TextField`, every factory must implement it.

---

## 5. Is Abstract Factory heavily used in frameworks?

Yes.

Examples:

* UI frameworks
* Spring BeanFactory concepts
* JDBC drivers
* cloud SDK integrations

---

# Final understanding

Think of Abstract Factory like a “factory of related factories.”

Its main goal is:

* create related objects together
* keep implementations interchangeable
* reduce coupling in object creation
