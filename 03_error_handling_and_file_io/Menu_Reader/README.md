# Menu Reader — Food Availability Parser

## Overview

A Java program that reads a tab-separated food data file and displays only available items in the format `name (category) -- description`. Demonstrates file parsing, parallel arrays, and exception handling.

## Skills Demonstrated

- File reading and tab-delimited parsing
- Parallel array storage (category, name, description, availability)
- User-prompted file selection
- Exception handling for I/O errors

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 03_error_handling_and_file_io/Menu_Reader/src
javac *.java
java Main
```

Enter `food.txt` when prompted (sample file included in `src/`).

## Highlights

- Filters items marked "Available" from tab-separated input
- Output format: `Ham sandwich (Sandwiches) -- Classic ham sandwich`
- Sample `food.txt` includes sandwiches, salads, drinks, and Mexican food entries
