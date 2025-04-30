# Die Game Simulation

## Description
This project implements a dice rolling simulation game that compares the outcomes between different types of dice. The simulation includes both fair dice and loaded dice, running 1,000 rolls to analyze the winning patterns.

## Features
- Fair Die implementation (values 1-6)
- Loaded Die implementation (values 2-6)
- Two simulation modes:
    - Fair Die vs Fair Die
    - Fair Die vs Loaded Die
- 1,000 roll simulation for statistical significance

## Project Structure
The project consists of the following main components:
- `Die.java` - Base class for a fair die (values 1-6)
- `LoadedDie.java` - Extended class for a loaded die (values 2-6)
- `LoadDieGame.java` - Main game simulation class
- `RollDiceResults.java` - Handles the dice rolling simulation logic

## How It Works
1. The game creates instances of different dice types
2. Each simulation runs 1,000 rolls
3. The program tracks when the first die wins (has a higher value)
4. Results are displayed showing the number of wins for Die1
against a LoadedDie object 1,000 times, and count the number of times the Die wins.
