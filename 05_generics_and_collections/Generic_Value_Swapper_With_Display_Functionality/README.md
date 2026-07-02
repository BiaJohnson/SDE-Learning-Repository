# Generic Value Swapper — Type-Safe Value Exchange

## Overview

A Java program demonstrating generic methods that swap and display values of different types (Strings and integers). Uses a modular design separating input handling, processing, and display.

## Skills Demonstrated

- Java generics and type parameters
- Generic method design for type-safe operations
- Modular class organization (input, processor, display)
- User input handling across data types

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 05_generics_and_collections/Generic_Value_Swapper_With_Display_Functionality/src
javac *.java
java Main
```

Or open the project folder in IntelliJ IDEA and run `Main`.

## Highlights

- `GenericProcessor<T>` swaps any comparable type without code duplication
- Separate modules for input (`InputHandler`), processing, and display (`DisplayManager`)
- Demonstrates how generics enable reusable logic across String and Integer types
