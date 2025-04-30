# Banking System Application

A Java-based banking system that simulates basic banking operations through a command-line interface.

## Features

- Account Management
    - Create Savings accounts
    - Create Checkings accounts
    - View account balances

- Transaction Operations
    - Cash deposits
    - Cash withdrawals
    - Check deposits (Checkings accounts only)
    - Check withdrawals (Checkings accounts only)

- Account Information
    - View individual account balances
    - View all accounts summary

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE (Eclipse, IntelliJ, etc.) or command line interface

## Usage

The application presents a menu-driven interface with the following options:

1. Create new accounts:
    - Option 1: Create a Savings account
    - Option 2: Create a Checkings account

2. View Balance:
    - Option 3: View Savings account balance
    - Option 4: View Checkings account balance
    - Option 5: View all accounts balance

3. Deposit:
    - Option 6: Deposit cash to Savings account
    - Option 7: Deposit cash to Checkings account
    - Option 8: Deposit a check

4. Withdrawal:
    - Option 9: Withdraw cash from Savings account
    - Option 10: Withdraw cash from Checkings account
    - Option 11: Withdraw using check

5. Exit:
    - Option 12: Exit the program

## Class Descriptions

- `BankingSystem`: Main entry point of the application
- `Bank`: Manages all bank accounts and operations
- `Account`: Abstract base class for all account types
- `SavingsAccount`: Implementation of savings account features
- `CheckingsAccount`: Implementation of checkings account features

## Error Handling

The application includes robust error handling for:
- Invalid input validation
- Account number validation
- Transaction amount validation
- Check number validation
