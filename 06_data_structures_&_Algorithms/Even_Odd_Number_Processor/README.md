# Even/Odd Number Processor

## 1. Executive Summary

The system processes a series of numbers by separating them into even and odd 
numbers using Stack and Queue data structures, implemented using arrays.

## 2. System Components

1. Main Class: SumOddEvenNumbers:
   - Purpose : Main entry point that handles user input and program coordination.
   - Key  Responsibilities :
     - User input validation.
     - Array initialization.
     - Number collection and processing. 
     - Coordination between OddStack and EvenQueue operations.

2. OddStack Class:
   - Purpose : Manages odd numbers using a Stack implementation
   - Key Components:
     - Array to store odd numbers.
     - Top pointer to track stack position.
   - Core Operations:
     - push(): Add odd number to stack.
     - pop(): Remove and return top number. 
     - isEmpty(): Check if stack is empty. 
     - isFull(): Check if stack is full. 
     - sum(): Calculate sum of odd numbers.

3. EvenQueue Class:
   - Purpose: Manages even numbers using a Queue implementation.
   - Key Components:
     - Array to store even numbers. 
     - Front and rear pointers.
   - Core Operations :
     - enqueue(): Add even number to queue.
     - dequeue(): Remove and return front number. 
     - isEmpty(): Check if queue is empty. 
     - isFull(): Check if queue is full. 
     - sum(): Calculate sum of even numbers.

## Data Flow
1. User inputs the quantity of numbers to process.
2. System validates input for positive integers. 
3. User enters numbers one by one. 
4. Each number is evaluated:
   - Even numbers → EvenQueue 
   - Odd numbers → OddStack
5. System calculates and displays sums.

## Error Handling
- Input validation for:
  - Initial quantity (positive integers only). 
  - Number inputs (using try-catch for InputMismatchException).
  - Stack/Queue overflow protection.
  - Empty structure checks.
  
## Process Flow
`````
[Start] → [User Input Phase]
    ↓
[Input Validation] 
    ↓
    |→ [Invalid] → [Error Message] → [Request New Input]
    |
    |→ [Valid] → [Number Collection Phase]
         ↓
[Process Each Number]
    ↓
    |→ [Is Even?] → [Yes] → [EvenQueue]
    |                        ↓
    |                    [Enqueue Operation]
    |                        ↓
    |                    [Update Queue Pointers]
    |
    |→ [No] → [OddStack]
              ↓
          [Push Operation]
              ↓
          [Update Stack Pointer]
    ↓
[All Numbers Processed?] → [No] → [Process Next Number]
    ↓
    [Yes]
    ↓
[Calculate Sums]
    ↓
    |→ [Process EvenQueue]
    |   ↓
    |   [Calculate Even Sum]
    |
    |→ [Process OddStack]
        ↓
        [Calculate Odd Sum]
    ↓
[Display Results]
    ↓
[End]
`````
## Core Tenets
1. Simplicity:
   - Keep implementations straightforward and maintainable. 
   - One operation should serve one clear purpose. 
   - Avoid unnecessary complexity in data structure operations.
2. Robustness in Error Handling: 
   - Never assume valid input. 
   - Fail fast and fail gracefully. 
   - Provide clear feedback for error conditions. 
   - Protect against buffer overflows and underflows.
3. Performance Efficiency:
   - Optimize operations for time complexity. 
   - Maintain O(1) for stack and queue operations. 
   - Minimize memory overhead. 
   - Avoid redundant calculations.
4. Data Integrity:
   - Ensure accurate separation of odd and even numbers. 
   - Maintain FIFO principle for queue operations. 
   - Maintain LIFO principle for stack operations. 
   - Preserve data consistency throughout operations.
5. User-Centric Design:
   - Provide clear instructions for input. 
   - Deliver meaningful error messages. 
   - Ensure predictable behavior. 
   - Present results in a readable format.
6. Code Maintainability: 
   - Follow consistent naming conventions.
   - Document critical sections and algorithms. 
   - Separate concerns between classes. 
   - Design for future extensibility.
7. Defensive Programming: 
   - Validate all inputs at entry points. 
   - Check boundary conditions. 
   - Handle edge cases explicitly.
