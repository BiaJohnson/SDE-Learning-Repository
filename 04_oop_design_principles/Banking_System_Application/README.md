# Banking System Application — Account Management CLI

## Overview

A menu-driven Java banking system that supports creating savings and checking accounts, viewing balances, and performing deposits and withdrawals including check transactions.

## Skills Demonstrated

- Encapsulation and abstract class design (`Account` hierarchy)
- Class hierarchy (Savings, Checkings accounts)
- Menu-driven CLI with input validation
- Transaction management and error handling

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 04_oop_design_principles/Banking_System_Application/src
javac *.java
java BakingSystem
```

Or open the project folder in IntelliJ IDEA and run `BakingSystem`.

## Highlights

- 12-option menu: create accounts, view balances, deposit/withdraw cash, deposit/withdraw checks
- `Bank` class manages all accounts; `Account` is the abstract base for account types
- Validates account numbers, transaction amounts, and check numbers
