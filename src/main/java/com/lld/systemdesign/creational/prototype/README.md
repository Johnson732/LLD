# Prototype Pattern

## 1. The problem it solves

Prototype solves the problem of creating new objects when an existing object is already very similar to what we need.

Instead of:

- creating a new object
- setting every field again
- repeating initialization logic

we can:

- clone an existing object
- modify only the necessary values

Prototype makes object creation faster and cleaner when many objects share similar data.

---

## 2. When to use it

Use Prototype when:

- object creation is expensive
- many objects are similar
- copying an existing object is easier than building one from scratch

Use cases:

- employee profile templates
- document templates
- game characters
- configuration objects
- UI component templates

Avoid Prototype when:

- objects are very simple to create
- cloning introduces unnecessary complexity
- deep-copy requirements are difficult to maintain

---

## 3. Real-world engineering examples

### Example: Employee Profile Templates

Imagine a company creates hundreds of engineering employee profiles.

Most engineers share:

- same department
- same permissions
- same default settings

Instead of constructing every profile from scratch:

1. Create one template profile.
2. Clone it.
3. Change only the fields that differ.

This reduces repetitive initialization logic.

Other good real-world examples:

- document templates
- game character templates
- workflow configurations
- UI widgets

---

## 4. Practical implementation insights

Important points to mention in interviews:

- create a prototype object
- clone that object when a similar object is needed
- customize only the changed properties
- think carefully about shallow copy vs deep copy

For interview explanation, this is enough:

1. create prototype object
2. clone prototype
3. modify cloned object

---

## Code walkthrough

### EmployeeProfile.java

This is the main Prototype example in this package.

What it does:

- represents an employee profile template
- supports cloning
- allows creation of similar profiles quickly

How it achieves Prototype:

- implements `Cloneable`
- overrides `clone()`
- returns a copied object

Why this is a good interview example:

- easy to visualize
- commonly used business scenario
- demonstrates object cloning clearly

---

### PrototypePattern.java

This is a tiny demo class.

What it does:

- creates one template profile
- clones the template
- modifies the cloned profile
- demonstrates reuse through copying

---

## Interview answer in one line

"Prototype creates new objects by copying an existing object instead of constructing a new one from scratch."

---

## What to say if the interviewer asks follow-up questions

### 1. What is the main benefit of Prototype?

Answer:

It reduces the cost and complexity of object creation by cloning existing objects.

---

### 2. What is shallow copy?

Answer:

A shallow copy duplicates primitive values but shares referenced objects.

Example:

Two cloned objects may reference the same Address object.

---

### 3. What is deep copy?

Answer:

A deep copy duplicates the entire object graph so cloned objects do not share internal references.

---

### 4. When is deep copy needed?

Answer:

When cloned objects must be completely independent from each other.

---

### 5. What are the disadvantages of Prototype?

You can mention:

- cloning can become complicated
- deep copying may be expensive
- maintaining clone logic can be difficult for large object graphs

---

### 6. Where is Prototype commonly used?

Answer:

Prototype is common in:

- game development
- document editors
- design tools
- workflow systems
- template-based applications