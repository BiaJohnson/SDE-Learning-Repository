# Idea Reader & Tracker

## Overview

A Java console application for reading and writing project idea files. The `IdeaReader` utility reads file contents with try-with-resources, while `IdeaTracker` provides a menu-driven interface for reading and saving ideas.

## Skills Demonstrated

- File reading with `FileInputStream` and try-with-resources
- Exception handling (`FileNotFoundException`, `IOException`)
- Menu-driven CLI design
- File writing with companion `IdeaWriter` class

## Tech Stack

- Java 9+ (uses `readAllBytes()`)

## How to Run

```bash
cd 03_error_handling_and_file_io/Idea_Reader/src
javac *.java
java IdeaTracker
```

Select option 1 to read a file (e.g. `sample-project-idea.txt`) or option 2 to write a new idea.

## Highlights

- `IdeaReader.readIdea()` uses try-with-resources for automatic stream cleanup
- Graceful error handling returns empty string and logs errors on failure

## Usage Example

```java
IdeaReader reader = new IdeaReader();
String contents = reader.readIdea("src/sample-project-idea.txt");
System.out.println(contents);
```
