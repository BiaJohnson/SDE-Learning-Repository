# Generic Binary Tree — Type-Safe Key-Value Storage

## Overview

A type-safe, generic binary tree implementation providing key-value storage and retrieval. Uses Java's `Optional` class for null-safe lookups and supports any comparable key type through generics.

## Skills Demonstrated

- Generic binary tree with type parameters
- Java `Optional` for null-safe retrieval
- Interface/implementation design (`BinaryTree`, `SimpleBinaryTree`)
- Modular node structure (`BinaryTreeNode`)

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Generic_Binary_Tree_Implementation
javac src/*.java -d out/production/Trees
java -cp out/production/Trees SimpleBinaryTree
```

Or open the project in IntelliJ IDEA and run `SimpleBinaryTree`.

## Highlights

- `BinaryTree<K, V>` interface defines insert, find, and traversal operations
- `SimpleBinaryTree` provides the concrete implementation with `Optional`-wrapped results
- Foundation for building BST, AVL, or red-black tree extensions
