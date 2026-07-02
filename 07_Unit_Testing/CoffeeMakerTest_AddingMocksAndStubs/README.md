# CoffeeMaker — Mocks & Stubs with Mockito

## Overview

JUnit tests for a coffee maker system that use Mockito to mock and stub the `RecipeBook` dependency, isolating the `CoffeeMaker` class under test. Covers recipe management, coffee brewing with payment/change, inventory updates, and duplicate recipe handling.

## Skills Demonstrated

- JUnit 4 test setup with `@Before`
- Mockito `mock()` and `when().thenReturn()` stubbing
- Dependency isolation for unit testing
- Testing payment, change, and inventory side effects
- Verifying recipe book interactions (add, delete, duplicates)

## Tech Stack

- Java
- JUnit 4, Mockito

## How to Run

Open the project in IntelliJ IDEA or Eclipse with JUnit and Mockito on the classpath, then run `CoffeeMakerTest` from the `test/` directory.

Requires the NC State CoffeeMaker library (`edu.ncsu.csc326.coffeemaker`).

## Test Coverage

| Test | What It Verifies |
|------|------------------|
| `testMakeCoffee01` | Valid recipe brew returns correct change and reduces inventory |
| `testMakeCoffee02` | Invalid recipe index returns full payment |
| `testMakeCoffee1` | Exact payment returns zero change |
| `testMakeCoffee2` | Overpayment returns correct change |
| `testMakeCoffee3` | Duplicate recipes are rejected |
| `testMakeCoffee4` | Recipe book capacity and duplicate handling |
| `testDeleteRecipe` | Recipe deletion returns correct names or null |
| `testDummy` / `testDummy2` | Recipe property validation (Latte ingredients and price) |

## Highlights

- `RecipeBook` is stubbed with Mockito so tests run without a real recipe database
- Tests verify both return values (change) and side effects (inventory depletion)
