# Bank Teller App — Queue Simulation

## Overview

A Java application that simulates a bank queue served by two tellers. Customers are alternately assigned to Teller 1 (odd positions) and Teller 2 (even positions), demonstrating queue-based processing and object interaction.

## Skills Demonstrated

- Queue data structure simulation
- Object interaction between teller and customer classes
- Iteration over collections
- Console output for transaction tracking

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 02_java_basics/Bank_Teller_App/src
javac *.java
java Main
```

Or open the project folder in IntelliJ IDEA and run `Main`.

## Highlights

- Predefined customer queue processed in order
- Odd-positioned customers (1, 3, 5…) served by Teller 1; even-positioned by Teller 2
- Displays which teller handles each customer transaction
