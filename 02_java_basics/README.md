# Palindrome Checker

## Overview

A Java CLI application that checks whether user-entered words or phrases are palindromes. Uses a two-pointer technique to compare characters from both ends, ignoring spaces, punctuation, and capitalization.

## Skills Demonstrated

- String processing and character comparison
- Two-pointer algorithm for palindrome detection
- Interactive CLI with session loop
- Input normalization (case, whitespace, punctuation)

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 02_java_basics/Palindrome_Checker/src
javac PalindromeChecker.java
java PalindromeChecker
```

Or open the project folder in IntelliJ IDEA and run `PalindromeChecker`.

## Highlights

- Continuous session: check multiple words before exiting
- Two-pointer approach avoids creating a reversed string copy
