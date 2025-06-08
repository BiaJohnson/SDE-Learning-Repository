
# Test Documentation – Number Processor App

## 1. Introduction
This document outlines the tests performed for the Number Processor App.

## 2. Test cases For ConsoleView

### 2.1 ConsoleView Class Description
View class that handles user interaction through the console. It gets input numbers from the user until they choose to stop.

### 2.2 Test Cases for ConsoleView

1. Input Processing Tests
- testGetInputNumbers_MultipleValidInputs: Tests processing of multiple valid number inputs, verifying:
  - Correct array creation
  - Proper confirmation messages for each number
  - Accurate count of processed numbers
- testGetInputNumbers_EmptyInput: Tests handling of immediate termination input, verifying:
  - Creation of empty array
  - Appropriate zero-count message
  - program termination
- testGetInputNumbers_WithNegativeNumbers: Tests processing of negative number inputs, verifying:
  - Correct handling of negative values
  - Proper array creation with negative numbers
  - Accurate confirmation messages
- testGetInputNumbers_WithMixedValidAndInvalidInput: Tests handling of mixed input types, verifying:
  - Processing stops at first invalid input
  - Only valid numbers before invalid input are stored
  - Proper error handling
2. Result Display Tests
- testDisplayResults_WithMixedNumbers: Tests display of mixed even and odd numbers, verifying:
  - Correct formatting of even numbers in input order
  - Correct formatting of odd numbers in reverse order
  - Accurate sum calculations for both types
- testDisplayResults_WithEmptyArrays: Tests display handling when no numbers are processed, verifying:
  - Appropriate "None" messages for both categories
  - Zero sum displays
  - Proper formatting of empty results
- testDisplayResults_WithOnlyEvenNumbers: Tests display with only even numbers, verifying:
  - Correct even number formatting and sum
  - Appropriate "None" message for odd numbers
  - Zero sum for empty odd category
- testDisplayResults_WithOnlyOddNumbers: Tests display with only odd numbers, verifying:
  - Correct odd number formatting in reverse order
  - Appropriate "None" message for even numbers
  - Zero sum for empty even category

### 2.2 Results for ConsoleView

![ConsoleView Test Results](TestResults/ConsoleViewTest.png)

 
--------------------------------------------------------------------------

## 3. Test cases For Main

### 3.1 Main Class Description
Main application class that coordinates the MVC components.

### 3.2 Test Cases for Main
1. Basic Input Processing Tests
- testMain_WithValidInput: Tests processing of valid even numbers, verifying:
  - Proper input prompts 
  - Correct confirmation messages for each number 
  - Accurate display of even numbers in sequence 
  - Correct sum calculation 
  - Proper formatting of results
- testMain_WithEmptyInput: Tests handling of immediate program termination, verifying:
  - Correct processing of zero numbers 
  - Appropriate "None" messages 
  - Zero sums for both even and odd categories 
  - Proper program termination
2. Mixed Input Tests
- testMain_WithMixedNumbers: Tests processing of mixed even and odd numbers, verifying:
  - Correct separation of even and odd numbers 
  - Proper ordering (normal for even, reverse for odd)
  - Accurate sum calculations for both categories 
  - Complete input confirmation messages 
  - Proper result formatting
- testMain_WithInvalidInput: Tests handling of non-numeric input, verifying:
  - Processing of valid numbers before invalid input 
  - Proper error handling 
  - Correct count of processed numbers 
  - Accurate results for valid numbers 
  - Program continues after invalid input
3. Special Cases
- testMain_WithNegativeNumbers: Tests processing of negative numbers, verifying:
  - Correct handling of negative values 
  - Proper categorization of negative even/odd numbers 
  - Accurate sum calculations with negative numbers 
  - Correct display formatting for negative values 
  - Proper ordering in result display

### 3.3 Results for MainTest

![ConsoleView Test Results](TestResults/MainTest.png)

--------------------------------------------------------------------------

## 4. Test cases For NumberProcessor, including ProcessingResult, CustomStack and CustomQueue

### 4.1 NumberProcessor, ProcessingResult, CustomStack and CustomQueue Class Description:

- NumberProcessor: Processes an array of numbers, separating them into even and odd, calculating their sums, and returning the results.
- ProcessingResult: Model class to store the results of number processing.
- CustomQueue: Optimized implementation of a Queue data structure using an array with efficient growth strategy for maximum performance.
- CustomStack: Optimized implementation of a Stack data structure using an array with efficient growth strategy for maximum performance.

### 4.2 Test cases for NumberProcessor Class, including ProcessingResult, CustomStack and CustomQueue

1. Basic Number Processing Tests
- testProcessingResult_WhenOnlyEvenNumbers: Tests processing of exclusively even numbers, verifying:
  - Correct storage of even numbers in original order
  - Accurate even sum calculation
  - Empty odd number array
  - Zero odd sum
- testProcessingResult_WhenOnlyOddNumbers: Tests processing of exclusively odd numbers, verifying:
  - Correct storage of odd numbers in reverse order
  - Accurate odd sum calculation
  - Empty even number array
  - Zero even sum
- testProcessingResult_WhenMixedNumbers: Tests processing of mixed numbers, verifying:
  - Proper separation of even and odd numbers
  - Correct ordering (original for even, reverse for odd)
  - Accurate sums for both categories
- testProcessingResult_WhenEmptyArray: Tests processing of empty input, verifying:
  - Empty result arrays
  - Zero sums for both categories
  - Proper handling of null case
2. Data Structure Implementation Tests
- testEnsureCapacity_WithCustomQueue: Tests CustomQueue capacity management, verifying:
  - Proper capacity expansion
  - Correct element ordering
  - Accurate size tracking
  - Element integrity during growth
- testEnsureCapacity_WithCustomStack: Tests CustomStack capacity management, verifying:
  - Proper capacity expansion
  - LIFO order maintenance
  - Correct element reversal
  - Size tracking accuracy
3. Performance and Scale Tests
- testGetSize_WithMultipleOperations: Tests size tracking through operations, verifying:
  - Accurate initial size
  - Correct size updates after enqueue operations
  - Proper handling of multiple operations
  - Size consistency
- testProcessingResult_WithLargeInput: Tests large dataset processing, verifying:
  - Correct handling of 1000 elements
  - Proper even/odd separation
  - Accurate element counts
  -  ordering in results
  - Performance with large datasets


### 4.3 Results for NumberProcessorTest

![ConsoleView Test Results](TestResults/NumberProcessorTest.png)

--------------------------------------------------------------------------
