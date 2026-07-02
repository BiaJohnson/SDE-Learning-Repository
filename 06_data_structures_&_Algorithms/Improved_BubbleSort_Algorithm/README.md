# Improved Bubble Sort — Optimized Sorting Algorithm

## Overview

An optimized bubble sort implementation that reduces unnecessary comparisons by tracking the last swap position and terminating early when the array is already sorted. Compares performance against a naive bubble sort.

## Skills Demonstrated

- Sorting algorithm implementation and optimization
- Early termination with a swapped flag
- Reducing comparison window via last-swap tracking
- Big-O analysis (best case O(n), worst case O(n²))

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Improved_BubbleSort_Algorithm/src
javac *.java
java BubbleSort
```

Or open the project folder in IntelliJ IDEA and run `BubbleSort`.

## Highlights

- Swapped flag detects when no further passes are needed
- Tracks the last unsorted element to shrink the comparison window each pass
- Separate `swap()` method for cleaner code organization
