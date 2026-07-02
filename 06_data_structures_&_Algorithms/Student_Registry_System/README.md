# Student Registry System — Linked-List Waiting List

## Overview

A Java application for managing student records with alphabetical ordering and navigation. Uses a `TreeMap`-backed registry and a linked-list waiting list for efficient ordering, lookup, and traversal.

## Skills Demonstrated

- Linked list implementation for waiting list management
- TreeMap for alphabetically ordered student records
- Navigation operations (first, last, next, previous)
- Enrollment status tracking (ENROLLED, UNDER-REVIEW, REJECTED)

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Student_Registry_System/src
javac Student.java ListManager.java WaitingList.java
java WaitingList
```

Or open the project folder in IntelliJ IDEA and run `WaitingList`.

## Highlights

- `ListManager` uses TreeMap for efficient alphabetical ordering and retrieval
- `WaitingList` demonstrates linked-list operations for queue management
- Supports find-by-last-name, status updates, and bidirectional navigation
