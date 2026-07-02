# Even/Odd Number Processor — Stack & Queue Implementation

## Overview

A Java program that separates a series of numbers into odd (stored in a custom stack) and even (stored in a custom queue) groups, then calculates sums for each. Implements both data structures using arrays.

## Skills Demonstrated

- Custom stack implementation (LIFO) with array backing
- Custom queue implementation (FIFO) with array backing
- Data structure operations: push, pop, enqueue, dequeue
- Coordination between multiple data structures

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Even_Odd_Number_Processor/src
javac *.java
java SumOddEvenNumbers
```

Or open the project folder in IntelliJ IDEA and run `SumOddEvenNumbers`.

## Highlights

- `OddStack` manages odd numbers with push/pop and sum operations
- `EvenQueue` manages even numbers with enqueue/dequeue and sum operations
- `SumOddEvenNumbers` coordinates user input, separation, and result display
