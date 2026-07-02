# Vehicle App — Autonomous Vehicle Hierarchy

## Overview

A Java vehicle management system demonstrating inheritance and polymorphism through an autonomous vehicle class hierarchy. Features Tesla-specific implementation with Autopilot network integration.

## Skills Demonstrated

- Inheritance and class hierarchies (`AutonomousVehicle` → `Tesla`)
- Polymorphism and method overriding
- Object composition and property management
- Formatted vehicle detail display

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 05_generics_and_collections/Vehicle_App/src
javac *.java
java Main
```

Or open the project folder in IntelliJ IDEA and run `Main`.

## Highlights

- `Tesla` extends `AutonomousVehicle` with Autopilot network integration
- Customizable properties: autonomy level, model, color, network system
- Override methods provide Tesla-specific detail display
