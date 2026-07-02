# Student Management System

## Overview

A Java application demonstrating exception handling with try-catch blocks across common failure scenarios: null object access, array index out of bounds, and division by zero. Processes student information while gracefully recovering from errors.

## Skills Demonstrated

- Try-catch exception handling
- `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`
- Student class modeling with encapsulation
- Defensive programming patterns

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 03_error_handling_and_file_io/Student_Management_System/src
javac *.java
java UseStudent
```

Or open the project in IntelliJ IDEA and run `UseStudent`.

## Highlights

- `printStudent()` catches null references when accessing student properties
- `listStudents()` handles array bounds errors from off-by-one iteration
- `thisIsRisky()` demonstrates division-by-zero recovery
- Intentionally triggers three exception types and catches each one instead of crashing
