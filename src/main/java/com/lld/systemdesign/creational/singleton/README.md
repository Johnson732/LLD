# Singleton Pattern

## 1. The problem it solves

Singleton solves the problem of creating multiple objects when the application should have only one shared instance.

If different modules create their own copies of the same manager object, it can lead to:

- inconsistent state
- duplicate configuration
- unnecessary memory usage
- difficult-to-control shared behavior

Singleton makes sure:

- only one object is created
- everyone uses the same object
- there is one global access point to that object

## 2. When to use it

Use Singleton when:

- exactly one instance is needed in the application
- that object represents shared state or shared coordination
- different parts of the system should access the same object

Use cases:

- application configuration manager
- logger manager
- cache manager
- feature flag manager

Avoid Singleton when:

- the class is stateless and can just be a utility class
- multiple instances may be needed later
- too much global state makes testing difficult

## 3. Real-world engineering examples

### Example: `ApplicationLogger`

In most applications, we do not want every service to create its own logger manager object.

Why?

- logging should be consistent across the application
- one shared logger manager is easier to control
- common settings such as log level or format should come from one place

That is why `ApplicationLogger` is a simple and realistic Singleton example for interviews.

Other good real-world examples:

- `ConfigurationManager`: load application settings once and share them
- `CacheManager`: maintain one in-memory cache coordinator
- `FeatureFlagManager`: keep one shared source of feature status

## 4. Practical implementation insights

Important points to mention in interviews:

- make the constructor `private` so no one can create objects directly
- keep one `private static` instance inside the class
- provide a public method like `getInstance()` to access that object
- if the application is multi-threaded, think about thread safety

For interview explanation, this is enough:

1. `private constructor`
2. `private static instance`
3. `public static getInstance()`

## Code walkthrough

### `ApplicationLogger.java`

This is the main Singleton example in this package.

What it does:

- stores a single logger object
- allows all classes to use the same logger manager
- provides a simple `log()` method

How it achieves Singleton:

- constructor is `private`
- instance is stored in a `private static final` field
- object is created only once when the class loads
- `getInstance()` returns that same object every time

Why this is a good interview example:

- very easy to explain
- real-world enough to sound practical
- no unnecessary complexity

### `SingletonPattern.java`

This is a tiny demo class.

What it does:

- gets the logger instance twice
- shows both references point to the same object
- demonstrates how Singleton is used in normal code

## Interview answer in one line

"Singleton ensures only one instance of a class exists and gives a global access point to it, which is useful for shared components like configuration, logging, or caching."

## What to say if the interviewer asks follow-up questions

### 1. What are the common ways to implement Singleton in Java?

You can mention:

- eager initialization
- lazy initialization
- synchronized `getInstance()`
- Bill Pugh holder pattern
- enum Singleton

Short answer:

"For simple explanation, I can start with eager initialization. If thread safety or lazy loading matters, I can discuss synchronized access, Bill Pugh holder pattern, or enum Singleton."

### 2. What are the disadvantages of Singleton?

You can mention:

- introduces global state
- increases coupling
- can make unit testing harder
- can create thread-safety issues if implemented poorly

Short answer:

"Singleton is useful, but overusing it can make code tightly coupled and harder to test."

### 3. Is Singleton always a good choice?

Answer:

No. Use it only when there should truly be one shared instance in the application. If multiple instances may be needed later, Singleton can become a bad design choice.

### 4. What about thread safety?

Answer:

In multi-threaded applications, Singleton creation must be thread-safe. A simple interview answer is:

- use eager initialization
- or use synchronized `getInstance()`
- or use Bill Pugh holder pattern
- or use enum Singleton

### 5. Do we always implement Singleton manually in Spring Boot?

Answer:

Not always. In Spring Boot, beans are singleton by default inside the IoC container, so in many real-world applications we rely on Spring-managed singleton beans instead of manually implementing the pattern.

### 6. What is the safest Java-specific Singleton implementation?

Answer:

`enum` Singleton is often considered the safest in Java because it handles serialization and reflection concerns better than many manual implementations.
