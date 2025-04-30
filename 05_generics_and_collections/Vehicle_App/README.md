# Vehicle Application System

## Overview
This project implements a vehicle management system with a focus on autonomous vehicles, specifically featuring Tesla implementation. The system demonstrates object-oriented programming principles including inheritance and polymorphism in Java.

## Project Structure
The project includes the following key components:
- `Tesla.java`: Extends the `AutonomousVehicle` class to implement Tesla-specific features
- `AutonomousVehicle.java` (parent class): Base class for autonomous vehicles

## Features
- Vehicle management system with autonomous driving capabilities
- Tesla-specific implementation with Autopilot network integration
- Customizable vehicle properties including:
  - Autonomy level
  - Model
  - Color
  - Network system

## Class Description

### Tesla Class
The `Tesla` class extends `AutonomousVehicle` and includes:
- Custom constructor for Tesla vehicle initialization
- Autopilot network integration
- Override methods for detailed vehicle information display

## Usage Example
```java
// Create a new Tesla vehicle
Tesla modelS = new Tesla(3, "Model S", "Red");

// Display vehicle details
modelS.printVehicleDetails();
