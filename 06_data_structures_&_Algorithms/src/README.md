# Library Search Engine

## 1. Executive Summary/Purpose

### 1.1 Summary
The Library Search Engine is a Java-based application that manages and searches through a collection of books. It provides users with the ability to perform various operations including searching, sorting, and managing book records through an interactive menu system.

### 1.2 Problem Statement
Libraries need an efficient system to manage their book collections and allow users to search through them effectively. This application addresses the need for organized book management, easy search capabilities, and proper data persistence.


## 3. Design Details

### 3.1 Architecture Overview:
The system consists of six main components:
1. Main - Entry point of the application
2. LibraryMenu - User interface handler
3. Library - Core business logic and book collection management
4. Book - Data model for book information
5. SortUtil - Utility class for sorting operations
6. UserInteractionLogger - Logging system for user actions
7. LibrarySerializer - Data persistence handler

### 3.2 Data Flow:
1. Program initialization:
   - Load existing book data through LibrarySerializer
   - Initialize Library with book collection
   - Start LibraryMenu interface

2. User interaction flow:
   - User selects operation from LibraryMenu
   - LibraryMenu processes request
   - Library executes operation
   - UserInteractionLogger records action
   - Results displayed to user

### 3.3 Functional Requirements

1. Book Management
   - Add new books to the library
   - Remove books from the library
   - Update book information
   - Search for books by various criteria

2. Search Operations
   - Search by title
   - Search by author
   - Search by publication year
   - Support partial matching

3. Data Operations
   - Sort books by different criteria using SortUtil
   - Persist library data using LibrarySerializer
   - Log all user interactions

4. User Interface
   - Display interactive menu
   - Show search results
   - Provide feedback for operations
   - Handle user input validation

### 3.4 Process Flow:

1. Application Start
   - Initialize system components
   - Load saved library data
   - Present main menu

2. Search Process
   - Accept search criteria
   - Process search request
   - Sort results if needed
   - Display results
   - Log operation

3. Data Management
   - Validate input data
   - Update persistent storage
   - Log changes

4. Application Exit
   - Save current state
   - Close resources
   - Exit gracefully

### 3.5 Class Responsibilities

1. Main
   - Application entry point
   - Component initialization
   - Error handling

2. LibraryMenu
   - User interface management
   - Input processing
   - Menu display
   - Operation routing

3. Library
   - Book collection management
   - Search operations
   - Data validation
   - Collection manipulation

4. Book
   - Book data structure
   - Data validation
   - Object comparison methods
   - String representation

5. SortUtil
   - Sorting algorithms
   - Comparison methods
   - Sort order management

6. UserInteractionLogger
   - Activity logging
   - Error logging
   - Operation tracking

7. LibrarySerializer
   - Data persistence
   - File I/O operations
   - Data format conversion

### 3.6 Sorting Algorithms Implementation

1. Title Sort (Selection Sort)
    - Implementation: Iterates through the list, finding the minimum element based on title
    - Time Complexity: O(n²)
    - Space Complexity: O(1)
    - Best for: Small lists where memory is a constraint
    - Process:
      * Finds smallest title in unsorted portion
      * Swaps it with first unsorted element
      * Repeats until all elements are sorted
    - Advantage: Simple implementation and no extra memory needed

2. Author Sort (Insertion Sort)
    - Implementation: Builds sorted array one element at a time by author name
    - Time Complexity: O(n²)
    - Space Complexity: O(1)
    - Best for: Nearly sorted lists and small datasets
    - Process:
      * Takes one element at a time
      * Inserts it into its correct position in sorted portion
      * Shifts other elements as needed
    - Advantage: Efficient for small data sets and partially sorted arrays

3. Publication Year Sort (Quick Sort)
   - Implementation: Divide-and-conquer algorithm using pivot selection
   - Time Complexity:
     * Average case: O(n log n)
     * Worst case: O(n²)
   - Space Complexity: O(log n)
   - Best for: Large datasets where performance is critical
   - Process:
     * Selects a pivot element
     * Partitions array around pivot
     * Recursively sorts sub-arrays
   - Advantage: Highly efficient for large datasets

### 3.7 Sorting Strategy Comparison

1. Performance Characteristics:
   - Selection Sort (Title):
     * Consistent performance regardless of input
     * Makes minimum number of swaps
     * Good for small lists

   - Insertion Sort (Author):
     * Best case O(n) for nearly sorted data
     * Adaptive algorithm
     * Efficient for small datasets

   - Quick Sort (Publication Year):
     * Best average-case performance
     * Efficient memory usage
     * Excellent for large datasets

2. Use Case Justification:
   - Title Sort:
     * Selected for titles as it maintains relative order of equal elements
     * Simple implementation for string comparison
     * Stable sorting important for title organization

   - Author Sort:
     * Chosen for authors as library data often comes partially sorted
     * Works well with string comparisons
     * Efficient for small continuous insertions

   - Publication Year Sort:
     * Implemented for years due to numeric nature of data
     * Handles large ranges of years efficiently
     * Quick performance for numerical sorting

3. Implementation Considerations:
   - Memory Usage:
     * Selection Sort: Minimal memory overhead
     * Insertion Sort: In-place sorting
     * Quick Sort: Recursive stack usage

   - Stability:
     * Selection Sort: Stable sort
     * Insertion Sort: Stable sort
     * Quick Sort: Not stable by default

   - Adaptability:
     * Selection Sort: Not adaptive
     * Insertion Sort: Highly adaptive
     * Quick Sort: Moderately adaptive


## 4. Appendices

### 4.1 Doc Data/Change Log

| Version | Author   | Status | Comments                    |
|---------|----------|--------|----------------------------|
| 1.0     | bcordeir | Draft  | Initial design document    |
| 1.1     | bcordeir | Update | Added implementation comparison |

