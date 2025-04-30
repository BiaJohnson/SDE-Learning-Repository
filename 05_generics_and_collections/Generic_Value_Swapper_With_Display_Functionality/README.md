# Generic Value Swapper with Display Functionality

## High Level Summary
This program demonstrates the use of generic methods in Java to handle different data types (Strings and integers). It showcases user input handling, value swapping, and display functionality using a modular approach. The design allows for easy extension to other data types and provides a clear separation of concerns between input handling, data processing, and output display.

## Detailed Design

### 1. Module Organization
1. **Main Application Module**
   - Handles program flow and user interaction

2. **Input Handler Module**
   - Manages user input for different data types

3. **Generic Processor Module**
   - Contains generic methods for swapping and displaying values

4. **Display Module**
   - Manages output formatting and display

### 2. Class Structure

1. **Main Class**
   - Entry point of the application
   - Manages overall program flow
   - Interacts with user and other modules

2. **InputHandler Class**
   - Methods for obtaining user input
   - Validation of input data

3. **GenericProcessor<T> Class**
   - Generic methods for processing data
   - Implements swapping functionality

4. **DisplayManager Class**
   - Methods for displaying data
   - Formatting output

### 3. Design Pattern
The program will use the **Strategy Pattern** with generics. This allows for:
- Flexible handling of different data types
- Easy extension to new data types without modifying existing code

### 4. Runtime Interaction

1. Main class initializes other modules
2. User input is collected via InputHandler
3. Data is passed to GenericProcessor for swapping
4. DisplayManager is called to show results before and after swapping
5. Process repeats for both String and Integer inputs

### 5. Key Methods

1. **Main Class**
 - `main(String[] args)`: Program entry point
 - `processInput<T>(T first, T second)`: Coordinates processing and display

2. **InputHandler**
 - `getStringInput()`: Obtains String input from user
 - `getIntegerInput()`: Obtains Integer input from user

3. **GenericProcessor<T>**
 - `swap(T& first, T& second)`: Swaps two values
 - `process(T first, T second)`: Coordinates swapping and display

4. **DisplayManager**
 - `display<T>(T first, T second)`: Displays two values

### 7. Error Handling
- Input validation in InputHandler
- Exception handling for type mismatches


