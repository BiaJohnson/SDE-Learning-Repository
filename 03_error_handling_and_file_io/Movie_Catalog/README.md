# Movie Catalog — Tabular Catalog Manager

## Overview

A Java application that manages a movie catalog with title, rating, and showtimes. Adds movies from a CSV file and displays them in a formatted table, merging duplicate titles by appending showtimes.

## Skills Demonstrated

- File I/O with CSV parsing
- Catalog management and duplicate handling
- Formatted table output
- Java 11 string utilities

## Tech Stack

- Java 11+ (uses `String.repeat()`)

## How to Run

```bash
cd 03_error_handling_and_file_io/Movie_Catalog/src
javac *.java
java MovieCatalogMachine
```

Sample data file `movies.csv` is included in `src/`.

## Highlights

- Automatically merges duplicate movie titles by adding new showtimes
- Clear table formatting with aligned columns
- Reads catalog data from CSV on startup
