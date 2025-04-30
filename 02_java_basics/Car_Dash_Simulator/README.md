# Car Dashboard Simulator

A console-based driving simulator that allows users to control a virtual car through basic driving operations.

## Description

This Car Dashboard Simulator is an interactive program that simulates basic car operations through a command-line interface. Users can perform essential driving functions while receiving real-time feedback on the car's status.

## Features

- **Start/Stop Engine**: Toggle the car's engine state
- **Gear Selection**: Choose between Drive (D) and Reverse (R) gears
- **Speed Control**:
    - Accelerate the vehicle
    - Apply brakes to reduce speed
- **Real-time Feedback**: Continuous display of car's current status
- **Safety Controls**: Prevents invalid operations (e.g., shifting gears while moving)

## How to Use

1. Run the program
2. Select from the following options:
    - Start the car
    - Select a gear (D/R)
    - Accelerate
    - Brake
    - Exit

## Controls and Logic

- **Engine State**: Boolean value tracking if the car is started/stopped
- **Gear Selection**: String value storing current gear (D/R)
- **Speed**: Integer value representing current speed
- **Braking**: Reduces speed by a fixed amount
- **Acceleration**: Increases speed by a fixed amount

## Requirements

- Java Runtime Environment (JRE)
- Console/Terminal access

## Safety Features

- Car must be started before selecting gear
- Speed control only works in valid gear positions
- Cannot shift gears while vehicle is in motion
- Speed limits enforced for safety
