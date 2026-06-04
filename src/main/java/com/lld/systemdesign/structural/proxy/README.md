# Proxy Pattern

## 1. The problem it solves

Proxy provides a placeholder or representative object that controls access to another object.

Sometimes directly accessing a real object can be:

- expensive
- slow
- remote
- insecure
- unnecessary every time

A Proxy sits between the client and the real object and decides how access should happen.

Proxy can:

- add caching
- add security checks
- add logging
- add lazy loading
- control remote communication

The client does not know whether it is talking to the real object or a proxy.

---

## 2. When to use it

Use Proxy when:

- object creation is expensive
- access should be controlled
- caching can improve performance
- remote calls should be hidden
- additional behavior is needed before or after method execution

Common use cases:

- API caching
- database access control
- remote service calls
- lazy loading large objects
- security authorization

Avoid Proxy when:

- there is no need to control access
- the additional layer adds unnecessary complexity

---

## 3. Real-world engineering examples

### Example: Cached API Access

Imagine an application calling an external user profile service.

Problems:

- external calls are slow
- external calls may cost money
- repeated requests return the same data

Instead of calling the external service every time:

1. Client calls Proxy
2. Proxy checks cache
3. If data exists, return cached data
4. Otherwise call the real service
5. Store result in cache
6. Return result

This reduces:

- latency
- API usage
- infrastructure cost

---

## 4. Practical implementation insights

Proxy typically contains:

1. Subject Interface
2. Real Subject
3. Proxy
4. Client

### Subject

Defines the contract.

Example:

```java
public interface ThirdPartyApi
```

### Real Subject

Contains actual business logic.

Example:

```java
public class RealThirdPartyApi
```

### Proxy

Controls access to the real object.

Example:

```java
public class CachedApiProxy
```

### Client

Uses the interface without knowing whether it talks to a proxy or the real object.

Example:

```java
ThirdPartyApi api = new CachedApiProxy();
```

---

## Code walkthrough

### ThirdPartyApi.java

The common contract.

Both Real API and Proxy implement this interface.

---

### RealThirdPartyApi.java

Represents the expensive external API.

Responsibilities:

- perform actual API call
- return requested data

---

### CachedApiProxy.java

Acts as the middle layer.

Responsibilities:

- check cache first
- call real API only when needed
- store results for future requests

Benefits:

- better performance
- reduced external calls
- transparent optimization

---

### ProxyPattern.java

Demonstrates how Proxy works.

Execution flow:

First call:

```text
Calling external API for user: 101
```

Second call:

```text
Returning cached result for user: 101
```

The second request never reaches the real API.

---

## Interview answer in one line

"Proxy provides a surrogate object that controls access to a real object while adding behavior such as caching, security, logging, or lazy loading."

---

## What to say if the interviewer asks follow-up questions

### 1. Difference between Proxy and Decorator?

Proxy controls access to an object.

Decorator adds new functionality to an object.

Proxy focuses on access control.

Decorator focuses on behavior enhancement.

---

### 2. Can Proxy improve performance?

Yes.

A caching proxy can prevent repeated expensive operations such as:

- API calls
- database queries
- file access

---

### 3. What is a Virtual Proxy?

A Virtual Proxy delays creation of an expensive object until it is actually needed.

Example:

- loading large images
- loading large documents

---

### 4. What is a Remote Proxy?

A Remote Proxy represents an object located on another server.

Examples:

- RPC
- gRPC
- RMI

The proxy hides network communication from the client.

---

### 5. What is a Protection Proxy?

A Protection Proxy checks permissions before allowing access.

Example:

```text
Admin User -> Allowed
Guest User -> Denied
```

---

### 6. Where is Proxy used in modern backend systems?

Common examples:

- Redis cache layer
- API gateway
- service mesh
- database access wrappers
- authentication middleware

Many caching and gateway systems internally follow Proxy principles.