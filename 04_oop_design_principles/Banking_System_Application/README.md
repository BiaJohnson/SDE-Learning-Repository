# Die Game — Dice Roll Simulation

## Overview

A Java dice simulation that compares outcomes between fair dice (values 1–6) and loaded dice (values 2–6). Runs 1,000 rolls per simulation to analyze winning patterns between different die types.

## Skills Demonstrated

- Inheritance (`LoadedDie` extends `Die`)
- Class hierarchy and method overriding
- Statistical simulation with repeated trials
- Randomization and result tracking

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 04_oop_design_principles/Die_Game/src
javac *.java
java LoadDieGame
```

Or open the project folder in IntelliJ IDEA and run `LoadDieGame`.

## Highlights

- Two simulation modes: Fair Die vs Fair Die, and Fair Die vs Loaded Die
- `Die` base class rolls 1–6; `LoadedDie` overrides to roll 2–6
- Tracks and reports how many times Die 1 wins across 1,000 rolls
