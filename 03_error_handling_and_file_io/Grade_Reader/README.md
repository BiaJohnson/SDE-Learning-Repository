# Grade Reader — TSV Report Generator

## Overview

A Java program that reads student grade data from a TSV file, assigns letter grades based on final exam scores, and writes a formatted report with per-student grades and exam averages.

## Skills Demonstrated

- TSV file parsing and file output
- Letter grade calculation logic
- Exception handling for missing files and invalid data
- Defensive input validation

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 03_error_handling_and_file_io/Grade_Reader/src
javac *.java
java Main
```

Place `StudentInfo.tsv` in the `src/` directory. Output is written to `report.txt`.

## Highlights

- Letter grades: A (≥ 90), B (80–89), C (70–79), D (60–69), F (< 60)
- Generates exam averages with two decimal places
- Handles missing files, incorrect format, and invalid grade values
