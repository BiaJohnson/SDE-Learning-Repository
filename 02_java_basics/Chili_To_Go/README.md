# Chili To Go — Meal Order Calculator

## Overview

A command-line Java application that calculates revenue from adult ($7.00) and child ($4.00) meal orders at a chili restaurant. Validates input and displays per-category and grand totals.

## Skills Demonstrated

- Methods and arithmetic calculations
- Input validation for non-negative integers
- Running total accumulation
- Error handling for invalid inputs

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 02_java_basics/Chili_To_Go/src
javac *.java
java ChiliToGo
```

For the profit-calculation variant, run `java ChiliToGoProfit` instead.

Or open the project folder in IntelliJ IDEA and run the desired main class.

## Highlights

- Two entry points: `ChiliToGo` (revenue) and `ChiliToGoProfit` (profit analysis)
- Separate pricing for adult and child meals with input validation
- Example: 2 adult + 3 child meals → $14.00 + $12.00 = **$26.00**
