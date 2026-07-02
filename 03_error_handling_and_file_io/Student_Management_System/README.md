# Student Search Program — File-Based Record Lookup

## Overview

A Java program that searches student records in a text file by name or ID. Validates file existence and format before searching, and supports multiple lookups in a single session with custom exception handling.

## Skills Demonstrated

- File validation and format checking
- Custom exceptions (`StudentNotFoundException`, `FileFormatException`)
- Bidirectional search (name → ID, ID → name)
- Scanner-based file reading with error recovery

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 03_error_handling_and_file_io/Student_Search_Program/src
javac *.java
java Main
```

Use `roster.txt` (included in `src/`) when prompted for a file name.

## Highlights

- `Database` class handles validation and search; `Main` drives the interactive menu
- Re-prompts for a new file if the input is missing or incorrectly formatted
- Each search opens a fresh `Scanner` to ensure correct file reading
