# Purchase Tracking System

# Summary
The Purchase Tracking System is a console-based Java application designed to help users track and categorize their purchases. The system allows users to input purchase categories and amounts, automatically organizes them by category, and provides formatted displays with category subtotals.

## Key Capabilities include:
- Interactive purchase entry with validation 
- Automatic category-based organization 
- Formatted currency display 
- Category subtotal calculations 
- Alphabetical sorting of purchases

## Core Modules
- **Main**: Entry point and user interaction handler
- **Purchase**: Represents a purchase with a category and price.
- **PurchaseDisplay**: Display and formatting logic

## Class Structure 
- **Main**
    - Entry point of the purchase tracking application
    - Manages user interaction and program flow
    - Key Methods:
        - `main(String[] args)`: Application entry point
        - Handles input loop for purchases.
        - Creates Purchase objects
        - Create instance of PurchaseDisplay class to handle output.


- **Purchase implements Comparable<Purchase>**
    - Implements data model for purchase information: category, Price.
    - Provides comparison functionality for sorting    
    - Key Methods:
        - `Purchase(String category, double price)`: Constructor
        - `getCategory()`: Returns purchase category
        - `getPrice()`: Returns purchase price
        - `compareTo(Purchase other)`: Compares purchases by category
        - `toString()`: Formats purchase for display


- **PurchaseDisplay**
    - Manages the presentation of purchase data
    - Handles sorting and grouping of purchases
    - Key Methods:
      - `showPurchases(ArrayList<Purchase> purchases)`: Main display method
      -  Sorts purchases by category
      -  Calculates category totalse
      -  Formats and displays purchase information


## Functionality Assignment
### Main Class
- Handles user interface logic
- Input validation
- Data collection
- Program initialization and termination

### Purchase Class
- Data storage (category, price)
- Implements Comparable for sorting
- Provides data access methods
- String representation of purchase data

### PurchaseDisplay Class
- Purchase list sorting
- Category grouping
- Total calculations
- Formatted output generation

## Runtime Interaction
### Flow
1. Main → Purchase
    - Creates purchase objects
    - Stores purchase data


2. Main → PurchaseDisplay
    - Passes collection of purchases
    - Initiates display process


3. PurchaseDisplay → Purchase
    - Reads purchase data
    - Sorts purchases
    - Groups by category

## Input Processing
1. User input → Main
2. Main validates input
3. Main creates Purchase object
4. Purchase added to collection

## Output Processing
1. Main sends collection to PurchaseDisplay
2. PurchaseDisplay sorts collection
3. PurchaseDisplay groups by category
4. PurchaseDisplay calculates totals
5. PurchaseDisplay formats and outputs results
