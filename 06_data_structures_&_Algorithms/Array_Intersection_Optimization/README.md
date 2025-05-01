# Array Intersection Optimization

## Table of Contents
- [1. Executive Summary/Purpose](#1-executive-summarypurpose)
- [2. Proposal](#2-proposal)
- [3. Design Details](#3-design-details)
- [4. Appendices](#4-appendices)

## 1. Executive Summary/Purpose 

*Intersection* is a Java program designed to show how to make Listed arrays and navigate through them finding their intersection with the best algorithm.
### 1.1 Background

As Java continues to be a widely used programming language, there is an ongoing need for clear, practical examples of advanced Java concepts. This will make use of Sorted ArrayLists, Map, HashMap, Sets in order achieve our goal.

### 1.2 Problem Statement

An application to help Java learner about array lists, intersection them, finding best time complexity

### 1.3 Current Situation

 Building an application that takes a pre-made set of Arrays of any type and intersect them.

## 2. Proposal

1. Prebuild two sets or more for testing of arrays with int, strings, 
2. intersect them using best time complexity

### 2.1 Stakeholders

- Java learners and educators
- Software Development Engineers (SDEs) looking to understand practical applications of generics and method overloading
- Our development team


### 2.2 Supporting Data

Studies show that if you apply what you just learned you will get a better understanding of the material

### 2.3 User Stories

1. We should have more hands-on experience with the material
2. How would we apply this in the real world
3. I forgot what these are

### 2.4 Architecture


```java
├── ArrayListComparison.java
├── README.md
├── designdoc.md
└── out
    └── production
        └── javadsa1-ra-day1-javadsa-group-5-p2
            ├── ArrayListComparison$ComparisonResult.class
            ├── ArrayListComparison.class
            ├── README.md
            └── designdoc.md

```

### 2.5 Alternatives
- HashMaps

## 3. Design Details

### 3.1 Functional Requirements

1. Run 
2. Intersects sets
3. Display new list of intersection

### 3.2 Non-Functional Requirements

1. Performance: Anything less than O(N^N)
2. Usability: Clear prompts and output for users
3. Maintainability: Well-commented code for easy understanding
4. Scalability: Design should allow for easy addition of new data types
5. Error Handing: Try-Catches in case of bad inputs (non int)

## 4. Appendices

### 4.2 Core Tenets

1. **Simplicity First**: Keep implementation straightforward
2. **Type Safety**: Ensure robust generic type handling
3. **Extensibility**: Design for future enhancements

### 4.3 FAQ

Q: Why use a generic method instead of separate methods for each type?
A: To demonstrate the power and flexibility of Java arrays.

Q: Can this program be extended to handle more data types?
A: Yes, by adding new overloaded display methods for additional types.

### 4.4 References/Other Resources

- [Java Documentation on ArrayList ](https://www.w3schools.com/java/java_arraylist.asp)

