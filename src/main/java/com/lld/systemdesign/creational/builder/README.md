# Builder Pattern

## 1. The problem it solves

Builder solves the problem of creating complex objects that contain many fields, especially when some fields are optional.

Without Builder, constructors can become difficult to read and maintain.

Example:

```java
new ApiClient(
    "https://api.payment.com",
    "api-key",
    3000,
    8000,
    5,
    true
);
```

Problems:

- parameter order becomes difficult to remember
- optional values make constructors grow
- readability decreases as fields increase
- constructor overloading becomes excessive

Builder provides a clean way to construct objects step by step.

## 2. When to use it

Use Builder when:

- objects have many properties
- some properties are optional
- object creation becomes difficult to read
- immutability is desired

Use cases:

- SDK clients
- HTTP requests
- database configurations
- cloud service configurations
- API request objects

Avoid Builder when:

- objects have only a few fields
- object creation is already simple

## 3. Real-world engineering example

### Example: ApiClient

Most enterprise applications communicate with external services.

A client may require:

- Base URL
- API Key
- Connection Timeout
- Read Timeout
- Retry Configuration
- Logging Settings

Some settings are mandatory.

Others are optional.

Builder allows developers to configure only what they need while keeping code readable.

Example:

```java
ApiClient client = new ApiClient.Builder(
        "https://api.payment.com",
        "api-key")
        .connectTimeout(3000)
        .retryCount(5)
        .loggingEnabled(true)
        .build();
```

This style is common in SDKs and framework configuration APIs.

## 4. Practical implementation insights

Important points to mention in interviews:

- Builder separates object construction from object representation
- mandatory fields can be enforced through the Builder constructor
- optional fields can be configured fluently
- build() creates the final object
- object can remain immutable

For interview explanation, this is enough:

1. Create Builder class
2. Set optional values using fluent methods
3. Call build()
4. Receive final object

## Code walkthrough

### ApiClient.java

This is the main Builder example.

What it does:

- represents an API client configuration
- supports mandatory and optional settings
- creates immutable objects

How it achieves Builder:

- constructor is private
- nested Builder class stores configuration
- Builder methods return the Builder instance
- build() creates the final object

Why this is a good interview example:

- realistic enterprise scenario
- demonstrates optional configuration clearly
- easy to explain

### BuilderPattern.java

This is a small demo class.

What it does:

- creates a payment API client
- creates a notification API client
- demonstrates different configurations using the same Builder

Benefits shown:

- readable object creation
- optional fields are easy to configure
- avoids constructor confusion

## Interview answer in one line

"Builder constructs complex objects step by step and improves readability when an object has many optional parameters."

## What to say if the interviewer asks follow-up questions

### 1. What advantages does Builder provide?

You can mention:

- better readability
- flexible object creation
- avoids telescoping constructors
- supports immutability

Short answer:

"Builder improves readability and maintainability when object construction becomes complex."

### 2. What are telescoping constructors?

Answer:

Multiple overloaded constructors created to support different combinations of parameters.

Example:

```java
ApiClient(String baseUrl, String apiKey)
ApiClient(String baseUrl, String apiKey, int timeout)
ApiClient(String baseUrl, String apiKey, int timeout, int retryCount)
```

Builder eliminates this problem.

### 3. Is Builder related to immutability?

Answer:

Yes.

Builder is commonly used to create immutable objects where fields are final and cannot change after construction.

### 4. Can Builder enforce mandatory fields?

Answer:

Yes.

Mandatory values can be required through the Builder constructor.

Example:

```java
new ApiClient.Builder(baseUrl, apiKey)
```

The object cannot be built without them.

### 5. How is Builder different from Factory Pattern?

Answer:

Builder focuses on constructing a complex object step by step.

Factory focuses on deciding which object implementation to create.

### 6. Where is Builder used in real projects?

Answer:

Builder is commonly used in:

- SDK clients
- HTTP request configuration
- cloud service clients
- database configuration objects
- request/response models

It is one of the most frequently used design patterns in enterprise Java applications.