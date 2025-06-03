# Student Information System (SIS)

A comprehensive Java-based management system for educational institutions to handle student records, subject enrollment, and exam schedules.

## Features

- Student Management
    - Add/Remove students
    - View alphabetical list of students
    - Search students by ID or name
    - Track student enrollment in subjects

- Subject Management
    - View available subjects
    - Alphabetical sorting of subjects
    - Subject assignment to students

- Exam Schedule Management
    - View exam schedules
    - Assign exam slots to students
    - Track multiple exam times per subject

## Technical Implementation

### Sorting Algorithms

- **Bubble Sort**: Used for sorting subjects alphabetically
- **Insertion Sort**: Implemented for sorting students by name
- **Binary Search**: Efficient student lookup by ID

### Data Structures

- **ArrayList**: Core storage for students, subjects, and exams
- **HashMap**: Quick access to exam schedules
- **TreeMap**: Ordered storage of student records

## Class Structure

### Main Classes

1. **Student**
    - Manages student information
    - Handles subject enrollment
    - Tracks exam schedules

2. **Subject**
    - Stores subject details
    - Manages subject IDs and names

3. **Exam**
    - Handles exam scheduling
    - Manages exam slots and timing

4. **Database**
    - Central data storage
    - Initializes test data
    - Manages relationships between entities

5. **StudentInfoSystem**
    - Core system functionality
    - Implements sorting and searching algorithms
    - Manages data operations

## Menu Options

### 1. Add Student
- Enter student details
- Select subjects (1-5)
- Choose exam slots

### 2. Remove Student
- Enter student number
- Confirm removal

### 3. View Students
- Display alphabetical list
- Show enrollment details

### 4. View Exam Schedule
- Enter student number
- Display all scheduled exams

### 5. Exit Program

## Sample Data

The system comes pre-loaded with:
- 50 sample students
- 10 subjects
- 20 exam slots

## Error Handling

- Input validation for all user entries
- Proper error messages for invalid operations
- Graceful handling of edge cases

## Performance

- Efficient sorting algorithms for large datasets
- Quick search capabilities using binary search
- Optimized data structure usage

## Requirements

- Java Runtime Environment (JRE) 8 or higher
- Terminal or IDE for running Java applications

