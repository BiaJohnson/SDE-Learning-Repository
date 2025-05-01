# Postfix Calculator Implementation Design

## Table of Contents
- [1. Executive Summary/Purpose](#1-executive-summarypurpose)
- [2. Proposal](#2-proposal)
- [3. Design Details](#3-design-details)
- [4. Appendices](#4-appendices)

## 1. Executive Summary/Purpose
The two Java programs: StackLinkedList and ArrayStack, are designed to demonstrate two different approaches to implementing a 
Stack data structure for a postfix calculator: using an Array (ArrayStack) and using a LinkedList (StackLinkedList). 
The program evaluates mathematical expressions written in postfix notation

### 1.1 Background

Stack is a fundamental data structure following the Last-In-First-Out (LIFO) principle, 
making it ideal for postfix expression evaluation. This implementation provides two different 
approaches to the stack data structure, allowing users to understand the trade-offs between array-based and linked-list-based implementations in a practical calculator application.

### 1.2 Problem Statement

Create a postfix calculator that:

- Implements a Stack using both array-based and linked-list approaches
- Evaluates postfix expressions using basic arithmetic operations (+, -, *, /)
- Demonstrates the practical application of stack operations in expression evaluation

## 2. Proposal

### 2.1 Stakeholders

- Developers maintaining the codebase
- End users requiring postfix expression evaluation
- QA team for testing


### 2.2 Architecture Overview:

---
Array Stack:
- ArrayStack: Main method to test postfix expression evaluation
- GetPostfixResult: evaluates postfix expressions using a stack-based approach:
  - GetPostfixResult ()
  - calculateResult ()
  - displayResult ()

Stack Linked List:
- StackLinkedList: Implementation of a Stack using a linked list data structure:
  - Node: represents each element in the linked list:
    - Node ()
    - push ()
    - pop ()
    - isEmpty ()
    - size ()
- PostfixOperations: Handles postfix expression operations:
  - PostfixOperations ()
  - processInput ()
  - isNumeric ()
  - isValidOperator ()
  - processOperator ()
  - performOperation
  - getResult
- PostfixCalculatorMain: Main class that runs the postfix calculator. Handles user input and calculator operation


### 3.1 Functional Requirements

1. Stack Operations:
   - Push:
     - Add elements to stack 
     - Handle stack growth (ArrayStack)
     - Create new nodes (StackLinkedList)

   - Pop:
     - Remove and return top element 
     - Handle empty stack conditions 
     - Update top/size counters

2. Calculator Functionality:
   - Input Processing:
     - Parse numeric inputs 
     - Validate operators (+, -, *, /)
   - Operation Handling:
     - Perform basic arithmetic (+, -, *, /)
     - Maintain operand order 
   - Error Handling:
     - Division by zero checks 
     - Invalid operator detection 
     - Insufficient operands validation
      
3. Output Requirements:
   - Display calculation steps
   - Show error messages 
   - Format numeric results 
   - Print stack status when needed

### 3.2 Non-Functional Requirements

1. Performance Characteristics:
- ArrayStack:
  - O(1) push/pop operations (amortized)
  - O(n) for array resizing 
  - Memory efficient for known sizes
- StackLinkedList:
  - O(1) push/pop operations 
  - Dynamic memory allocation 
  - No resizing overhead

2. Error Handling:
- Robust error messages:
  - "Error: Not enough operands for operator"
  - "Error performing operation: message"
  - "Stack is empty"
  - "Invalid operator"

3. Code Quality:
- Clear method documentation
- Consistent error handling

4. Maintainability:

- Modular design
- Separated concerns:
  - Stack operations 
  - Calculator logic 
  - Input processing 
  - Well-documented methods 
  - Clear variable naming
  
5Scalability:

- ArrayStack:
  - Dynamic array resizing 
  - Configurable initial capacity
- StackLinkedList:
  - No size limitations 
  - Efficient memory usage for large expressions

## Implementation Comparison

| Feature                    | ArrayStack Calculator                 | StackLinkedList Calculator                                      |
|---------------------------|---------------------------------------|-----------------------------------------------------------------|
| Memory Management         | Fixed initial size                    | Dynamic sizing (grow as needed                                  |
| Expression Length         | Limited by array size                 | Limited by available memory                                     |
| Memory Efficiency         | More memory efficient (less overhead) | Less memory efficient (extra space for pointers)                |
| Implementation Complexity | Simpler (array-based operations)      | Node management overhead (requires node and pointer management) |

## 4. Appendices

### 4.1 Doc Data/Change Log

| Version | Author | Status | Comments |
|---------|--------|--------|----------|
| 1.0     | bcordeir | Draft  | Initial design document |

### 4.2 Core Tenets

1. **Postfix Evaluation** : Maintain correct order of operations 
2. **Data Structure Integrity** : Ensure LIFO principle 
3. **Type Safety** : Handle numeric operations safely 
4. **User Experience** : Clear input/output interface 
5. **Error Handling** : Robust expression validation

### 4.3 FAQ

Q: Why use postfix notation?
A: Postfix notation eliminates the need for parentheses and simplifies expression evaluation using a stack.

Q: Which implementation should I choose?
A: Use ArrayStack for smaller, fixed-size calculations. Use StackLinkedList for applications where expression size varies significantly.
