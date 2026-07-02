# VehicleApp — Unit Tests

## Overview

JUnit tests for an autonomous vehicle application built with MVC architecture. Tests cover the model (`AutonomousVehicle` hierarchy), controller (`VehicleController`), and view (`VehicleView`, `AutonomousVehicleApp`) layers with documented test cases and results.

## Skills Demonstrated

- MVC layer unit testing
- Testing inheritance hierarchies (Tesla, Toyota, GM vehicles)
- View display and menu interaction testing
- Controller logic validation
- Test documentation with screenshots

## Tech Stack

- Java, JUnit 4

## How to Run

Open the project in IntelliJ IDEA or Eclipse and run test classes from the `Test/` directory:

- `AutonomousVehicleTest`
- `VehicleControllerTest`
- `VehicleViewTest`
- `AutonomousVehicleAppTest`

## Highlights

- Full MVC test coverage across model, view, and controller
- Detailed [TestDoc](Test/TestDoc.md) with per-class test cases, results screenshots, and code optimization notes

## Test Coverage

| Layer | Test Class | Focus |
|-------|-----------|-------|
| Model | `AutonomousVehicleTest` | Vehicle properties, turn history, direction |
| Controller | `VehicleControllerTest` | Vehicle selection, turn processing |
| View | `VehicleViewTest` | Menu display, input validation, summary reports |
| App | `AutonomousVehicleAppTest` | Application integration flow |
