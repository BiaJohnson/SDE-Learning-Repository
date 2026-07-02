# MergedTester — HashMap Merge Validation

## Overview

A Java program that tests `HashMap` merge behavior when combining multiple maps with overlapping keys. Validates that duplicate keys combine values correctly and unique keys are preserved using `TreeMap` and `TreeSet`.

## Skills Demonstrated

- HashMap merge operations and key collision handling
- TreeMap and TreeSet for ordered, deduplicated results
- Test-driven verification of map behavior
- Value aggregation across overlapping keys

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/MergedTester/src
javac *.java
java MergedTester
```

Or open the project folder in IntelliJ IDEA and run `MergedTester`.

## Highlights

- Tests merging HashMaps with String keys and Integer values
- Verifies correct handling of duplicate keys, unique keys, and value combination
- Uses ordered collections to present deterministic test output
