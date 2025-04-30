# Reverse Array 

# Summary
The Array Reversal System is a Java application designed to reverse the order of elements in an array. 
The system allows users to input array elements, reverses their order, and displays the reversed array 
in a formatted manner.

## Key Capabilities include:
- Interactive array element entry
- Array reversal functionality
- Formatted array display
- Modular design with separated concerns

## Core Modules
- **Main**: Entry point and program coordinator
- **ArrayReverser**: Core array manipulation logic
- **GetInput**: User input handling
- **PrintArray**: Output formatting and display

## Class Structure
- **Main**
    - Entry point of the array reversal application
    - Coordinates between input, reversal, and display modules
    - Key Methods:
        - `main(String[] args)`: Application entry point
        - Orchestrates program flow
        - Creates instances of other classes

- **ArrayReverser**
    - Implements core array reversal logic
    - Key Methods:
        - `ArrayReverser(int[] array)`: Constructor
        - `reverse()`: Performs array reversal
        - `getArray()`: Returns current array state

- **GetInput**
    - Manages user input operations
    - Key Methods:
        - `GetInput()`: Constructor
        - `getInputArray(int size)`: Collects user input
        - `close()`: Cleanup resources

- **PrintArray**
    - Handles array display formatting
    - Key Methods:
        - `printArray(int[] array)`: Displays formatted array
        - `printOriginalArray(int[] array)`: Shows initial array
        - `printReversedArray(int[] array)`: Shows reversed array

## Functionality Assignment
### Main Class
- Program initialization
- Module coordination
- Program flow control
- Resource management

### ArrayReverser Class
- Reversal algorithm implementation
- Array manipulation operations

### GetInput Class
- User interaction
- Input validation
- Array population
- Scanner management

### PrintArray Class
- Output formatting
- Array visualization
- Display management

## Runtime Interaction
### Flow
1. Main → GetInput
    - Requests user input 
    - Validates input 
    - Creates initial array


2. Main → ArrayReverser 
    - Passes initial array 
    - Initiates reversal process


3. Main → PrintArray
    - Displays original array 
    - Shows reversed array

## Input Processing
1. User input → GetInput 
2. GetInput validates input 
3. GetInput creates array 
4. Array passed to Main

## Output Processing
1. Main sends array to PrintArray
2. PrintArray formats array
3. PrintArray displays results
