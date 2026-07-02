# Library Search Engine — Book Catalog Manager

## Overview

A Java application for managing and searching a book collection through an interactive menu. Supports adding/removing books, searching by title/author/year, sorting with multiple algorithms, and persisting data via serialization.

## Skills Demonstrated

- HashMap-based book catalog management
- Multiple sorting algorithms (selection, insertion, quick sort)
- Object serialization for data persistence
- Menu-driven CLI with interaction logging

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Library_Search_Engine
javac src/*.java -d out
java -cp out Main
```

Book data is stored under `src/resources/data/`.

## Highlights

- Three sorting strategies: selection sort (title), insertion sort (author), quick sort (year)
- `LibrarySerializer` persists catalog data; `UserInteractionLogger` records all actions
- Search supports partial matching on title, author, and publication year
