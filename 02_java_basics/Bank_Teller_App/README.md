# Bank Teller Application

## Description
This Java application simulates a bank queue management system where customers are processed by two tellers. The application demonstrates how customers in a queue are alternately served by two tellers, with odd-numbered positions going to Teller 1 and even-numbered positions going to Teller 2.

## Features
- Manages a queue of bank customers
- Implements two teller stations for parallel customer processing
- Alternates customer assignments between tellers
- Tracks customer positions in line
- Processes transactions in an organized manner

## Code Structure
- `Main.java`: Contains the main program logic and customer queue management
- `Teller.java`: Teller class implementation (not shown in the provided code)

## How It Works
1. The application initializes with a predefined list of customers in queue
2. Creates two teller objects (Teller 1 and Teller 2)
3. Processes the customer queue as follows:
    - Customers in odd-numbered positions (1,3,5,...) are served by Teller 1
    - Customers in even-numbered positions (2,4,6,...) are served by Teller 2

## Usage
To run the application:
1. Ensure you have Java installed on your system
2. Compile the Java files
3. Run the Main class

The application will display:
- A welcome message
- Processing status for each customer transaction
- Details of which teller is serving each customer

## Dependencies
- Java Runtime Environment (JRE)
- Java Development Kit (JDK)
