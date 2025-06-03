# Student Registry System

A Java-based application for managing student records with alphabetical ordering and efficient navigation capabilities.

## Features

- List all enrolled students
- Find students by last name
- Update student enrollment status
- Remove students from the system
- Navigate through student records (first, last, next, previous)
- Automatically maintained alphabetical ordering

## Class Structure

### Student Class
Represents individual student records with:
- Student ID
- First Name
- Last Name
- Enrollment Status (ENROLLED, UNDER-REVIEW, REJECTED)

### ListManager Class
Manages the collection of students using TreeMap for efficient ordering and retrieval:
- Add/Remove students
- Update student status
- Find students by last name
- Navigate through ordered student records

### WaitingList Class
Main application class providing:
- Interactive menu interface
- Input validation
- Sample data initialization

## Usage

1. Compile the Java files:
```bash
javac Student.java ListManager.java WaitingList.java
```

2. Run the program:

java WaitingList

3. Use the menu options (1-9):

1: List all Students
2: Find Student by lastname
3: Change Student status
4: Remove Student
5: List first Student
6: List last Student
7: Find Next Student
8: Find Previous Student
9: Exit Program

### Data Structure

The system uses a TreeMap data structure which:

- Maintains natural ordering of students by last name
- Provides O(log n) time complexity for most operations
- Ensures efficient navigation through ordered records

### Input Validation

The system includes validation for:

- Menu selection inputs
- Student last name entries
- Null/empty value checking

### Error Handling

- Invalid input handling for menu selections
- Proper messaging for student not found cases
- Graceful handling of edge cases (first/last student navigation)

## Requirements

- Java Runtime Environment (JRE) 8 or higher
- Command line interface or IDE for compilation and execution