# Video Settings Serialization

## Overview
This project demonstrates Java serialization and deserialization capabilities by implementing a video settings management system. It allows users to save and load video configuration settings to/from files, ensuring persistence across application sessions.

## Features
- Serialize a `VideoSettings` object and save it to a file.
- Deserialize the saved object to restore its state.
- Verify that the loaded settings match the original settings.
- Handle potential exceptions during file operations.

## Learning Objectives
- Understand Java Serialization and Deserialization.
- Learn how to use ObjectOutputStream and ObjectInputStream.
- Handle common exceptions (IOException, ClassNotFoundException).
- Ensure data persistence across program executions.

## Error Handling
The application handles common exceptions including:

- IOException for file operations
- ClassNotFoundException for deserialization issues
- Invalid settings values

## Best Practices
- Always close file streams after operations
- Validate settings before saving
- Handle exceptions appropriately
- Use try-with-resources for automatic resource management

