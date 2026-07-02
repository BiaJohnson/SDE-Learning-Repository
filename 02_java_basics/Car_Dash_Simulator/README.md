# Car Dashboard Simulator — Interactive Driving Console

## Overview

A console-based driving simulator where users control a virtual car through start/stop, gear selection, acceleration, and braking. Enforces safety rules such as requiring the engine to be on before shifting gears.

## Skills Demonstrated

- State management (engine, gear, speed)
- Method-based simulation logic
- Input validation and safety constraints
- Interactive CLI menu design

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 02_java_basics/Car_Dash_Simulator/src
javac *.java
java Main
```

Or open the project folder in IntelliJ IDEA and run `Main`.

## Highlights

- Toggle engine, select Drive (D) or Reverse (R), accelerate, and brake
- Prevents invalid operations (e.g. shifting gears while moving)
- Real-time status feedback after each action
