# Reverse Array — Modular Array Reversal

## Overview

A Java application that accepts user-entered array elements, reverses their order in place, and displays both the original and reversed arrays. Uses a modular design with separated input, reversal, and display concerns.

## Skills Demonstrated

- Array manipulation and in-place reversal
- Modular class design with single responsibilities
- User input collection and validation
- Formatted console output

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 05_generics_and_collections/Reverse_Array/src
javac *.java
java Main
```

Or open the project folder in IntelliJ IDEA and run `Main`.

## Highlights

- `ArrayReverser` handles the core reversal algorithm
- `GetInput` collects elements; `PrintArray` formats original and reversed output
- `Main` coordinates the flow between modules
