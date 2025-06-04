# Generic Binary Tree Implementation in Java

A type-safe, generic binary tree implementation that provides efficient key-value storage and retrieval operations. This implementation uses Java's Optional class to handle null values safely and supports any comparable key type.

The project implements a binary tree data structure with a clean, modular design using Java generics. It provides a flexible foundation for building more complex tree-based data structures like binary search trees, AVL trees, or red-black trees. The implementation focuses on type safety and null handling through Java's Optional class, making it robust for production use.

## Repository Structure
```
.
├── src/                           # Source code directory
│   ├── BinaryTree.java           # Core interface defining tree operations
│   ├── BinaryTreeNode.java       # Node implementation with generic key-value storage
│   └── SimpleBinaryTree.java     # Concrete binary tree implementation
├── out/                          # Compiled bytecode directory
│   └── production/
│       └── Trees/               # Compiled class files
└── Trees.iml                     # IntelliJ IDEA module file
```

## Usage Instructions
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (IntelliJ IDEA recommended) or command line tools

### Installation
1. Clone the repository:
```bash
git clone <repository-url>
cd binary-tree
```

2. Build the project:
```bash
# Using command line
javac src/*.java -d out/production/Trees

# Using IntelliJ IDEA
# Open the project and Build > Build Project
```

### Quick Start
```java
// Create a new binary tree instance
BinaryTree<Integer, String> tree = new SimpleBinaryTree<>();

// Insert key-value pairs
tree.put(5, "Five");
tree.put(3, "Three");
tree.put(7, "Seven");

// Retrieve values
Optional<String> value = tree.get(5); // Returns Optional containing "Five"
```

### More Detailed Examples
```java
// Create a tree with String keys and Integer values
BinaryTree<String, Integer> tree = new SimpleBinaryTree<>();

// Insert multiple values
tree.put("A", 1);
tree.put("B", 2);
tree.put("C", 3);

// Safe value retrieval
Optional<Integer> value = tree.get("B");
value.ifPresent(System.out::println); // Prints: 2

// Handle missing keys
Optional<Integer> missing = tree.get("Z");
System.out.println(missing.isPresent()); // Prints: false
```

### Troubleshooting
Common issues and solutions:

1. NullPointerException when inserting keys
```java
// Wrong: Inserting null key
tree.put(null, "value"); // Will throw NullPointerException

// Correct: Always use non-null keys
tree.put(1, "value");
```

2. Type mismatch errors
```java
// Wrong: Mixing incompatible types
BinaryTree<Integer, String> tree = new SimpleBinaryTree<>();
tree.put("string", "value"); // Compilation error

// Correct: Use consistent types
tree.put(1, "value");
```

## Data Flow
The binary tree implements a hierarchical data structure where each node contains a key-value pair and references to left and right child nodes. Data operations traverse the tree structure based on key comparisons.

```ascii
       [Root Node]
      /          \
 [Left Node]  [Right Node]
    /    \       /    \
   []    []     []    []
```

Component interactions:
1. Node Creation: New nodes are created with key-value pairs
2. Tree Traversal: Operations traverse nodes based on key comparisons
3. Value Storage: Values are stored in nodes and retrieved by key
4. Optional Handling: Null values are wrapped in Optional for safe handling
5. Generic Type Support: Keys and values can be of any object type
6. Node Linking: Nodes maintain parent-child relationships through references
7. Memory Management: Java garbage collection handles node cleanup automatically
