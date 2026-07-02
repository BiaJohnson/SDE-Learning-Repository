# Virtual Coffee Machine — Polymorphic Beverage System

## Overview

An object-oriented coffee machine that brews multiple beverage types through a class hierarchy. Each coffee variety has its own preparation method, demonstrating polymorphism and separation of concerns.

## Skills Demonstrated

- Polymorphism and method overriding
- Class hierarchy for beverage types
- Separation of concerns (preparation vs display)
- Utility class design for shared preparation logic

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 04_oop_design_principles/Virtual_Coffee_Machine_Project/src
javac *.java
java CoffeeMachine
```

Or open the project folder in IntelliJ IDEA and run `CoffeeMachine`.

## Highlights

- Hierarchy of coffee beverages with unique preparation methods per type
- `CoffeeUtility` class centralizes shared brewing logic
- Extensible design: new coffee types can be added without modifying existing code
