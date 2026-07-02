# Purchase Tracking System — Category-Based Expense Tracker

## Overview

A console-based Java application for tracking purchases by category. Users enter category and amount pairs; the system organizes, sorts, and displays purchases with per-category subtotals.

## Skills Demonstrated

- Collections (`ArrayList`) and the `Comparable` interface
- Category-based grouping and alphabetical sorting
- Formatted currency display
- Modular design (data model, display, main coordinator)

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 05_generics_and_collections/Purchase_Tracking_System/src
javac *.java
java Main
```

Or open the project folder in IntelliJ IDEA and run `Main`.

## Highlights

- `Purchase` implements `Comparable<Purchase>` for category-based sorting
- `PurchaseDisplay` groups purchases and calculates category subtotals
- Interactive input loop with validation until the user exits
