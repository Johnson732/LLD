# Composite Pattern

## 1. The problem it solves

Composite solves the problem of treating individual objects and groups of objects in the same way.

Without Composite:

- client code needs separate logic for single objects
- client code needs separate logic for collections
- hierarchy structures become difficult to manage

Composite makes sure:

- leaf objects and groups share a common interface
- clients interact with both uniformly
- tree-like structures become easy to work with

---

## 2. When to use it

Use Composite when:

- objects naturally form a hierarchy
- you need tree structures
- individual objects and groups should be handled the same way

Common examples:

- file systems
- organization hierarchy
- UI components
- cloud infrastructure groups
- menu systems

Avoid Composite when:

- there is no hierarchical relationship
- grouping behavior adds unnecessary complexity

---

## 3. Real-world engineering examples

### Example: Infrastructure Monitoring Dashboard

Imagine a cloud platform.

Production Environment
│
├── Nginx Server
│
└── Backend Cluster
│
├── Auth Service
├── Payment Service
└── User Service

A monitoring dashboard should be able to:

- show status of a single server
- show status of an entire cluster
- show status of a complete environment

Composite allows all of them to be treated as
InfrastructureComponent.

---

## 4. Practical implementation insights

Composite has three main participants:

### Component

Common interface shared by all objects.

Example:

```java
InfrastructureComponent
```

### Leaf

Represents an individual object.

Example:

```java
Server
```

### Composite

Represents a group of objects.

Example:

```java
InfrastructureGroup
```

The Composite itself implements the same interface
and can contain both Leaf and Composite objects.

---

## Code walkthrough

### InfrastructureComponent.java

Defines the common contract.

```java
void showStatus();
```

Both servers and groups implement it.

---

### Server.java

Leaf implementation.

Represents one server.

Example:

```java
Server authServer =
        new Server("Auth-Service");
```

It cannot contain children.

---

### InfrastructureGroup.java

Composite implementation.

Can contain:

- Server objects
- other InfrastructureGroup objects

Methods:

```java
add()
remove()
showStatus()
```

This creates recursive tree structures.

---

### CompositePattern.java

Demonstrates usage.

Creates:

- individual servers
- backend cluster
- production environment

Then displays everything using a single call:

```java
productionEnvironment.showStatus();
```

Client code does not care whether it is dealing with:

- one server
- one cluster
- an entire environment

That is the key benefit of Composite.

---

## Interview answer in one line

"Composite allows individual objects and groups of objects to be treated uniformly by organizing them into a tree structure using a common interface."

---

## What to say if the interviewer asks follow-up questions

### 1. What is the biggest advantage?

It simplifies client code because leaf objects and composite objects are used through the same interface.

---

### 2. Where is Composite used in real projects?

Examples:

- file systems
- UI frameworks
- organization hierarchies
- menu systems
- cloud resource groups

---

### 3. What design principle does it support?

Composite follows:

- Open/Closed Principle
- Dependency Inversion Principle

because clients depend on abstractions instead of concrete implementations.

---

### 4. What is the difference between Composite and Decorator?

Composite:

- represents part-whole hierarchies
- focuses on tree structures

Decorator:

- adds behavior dynamically
- focuses on extending functionality

---

### 5. What is the relationship between parent and child nodes?

The Composite stores children through the Component abstraction:

```java
List<InfrastructureComponent>
```

This allows storing both:

- Server
- InfrastructureGroup

inside the same collection.

---

### 6. Where might I see this in Spring or enterprise applications?

Examples:

- API gateway route groups
- infrastructure monitoring dashboards
- workflow hierarchies
- menu/navigation systems
- file and folder management systems