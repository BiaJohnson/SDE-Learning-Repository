# Video Settings Serialization — Object Persistence

## Overview

A Java demonstration of object serialization and deserialization. Saves a `VideoSettings` object to a binary file and restores it in a later session, verifying that all settings match the original state.

## Skills Demonstrated

- Java serialization with `ObjectOutputStream` / `ObjectInputStream`
- Data persistence across program executions
- Exception handling (`IOException`, `ClassNotFoundException`)
- Try-with-resources for stream management

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 03_error_handling_and_file_io/Video_Settings_Serialization/src
javac *.java
java VideoSettingsTest
```

Or open the project folder in IntelliJ IDEA and run `VideoSettingsTest`.

## Highlights

- Serializes video configuration settings to a file, then deserializes and verifies equality
- Handles file I/O and deserialization errors gracefully
- Demonstrates best practices: close streams, validate settings before saving
