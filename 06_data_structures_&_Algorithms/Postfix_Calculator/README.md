# Postfix Calculator — Dual Stack Implementations

## Overview

Two Java implementations of a postfix expression evaluator: one using an array-based stack (`ArrayStack`) and one using a linked-list stack (`StackLinkedList`). Evaluates mathematical expressions in postfix notation using basic arithmetic operators.

## Skills Demonstrated

- Stack data structure (LIFO principle)
- Array-based vs linked-list implementation trade-offs
- Postfix expression evaluation
- Error handling (division by zero, insufficient operands)

## Tech Stack

- Java (JDK 8+)

## How to Run

**Linked-list implementation:**

```bash
cd 06_data_structures_&_Algorithms/Postfix_Calculator/src
javac StackLinkedList.java
java StackLinkedList
```

**Array-based implementation:**

```bash
cd 06_data_structures_&_Algorithms/Postfix_Calculator/src
javac "ArrayStack.java Copy path"
java "ArrayStack"
```

## Highlights

- Postfix notation eliminates parentheses; operands are pushed, operators pop two values and push the result
- ArrayStack: O(1) amortized push/pop, fixed initial capacity with dynamic resizing
- StackLinkedList: O(1) push/pop, no size limit, higher memory overhead per node
