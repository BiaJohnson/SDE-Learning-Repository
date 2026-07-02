# Unit Testing

Java projects demonstrating unit testing with JUnit and Mockito, including test-driven development practices, mock objects, and stubbed dependencies.

## Skills Demonstrated

- JUnit test writing and execution
- Test-Driven Development (TDD) lifecycle
- Mockito mocks and stubs for dependency isolation
- MVC layer testing (model, view, controller)
- Test documentation and coverage analysis

## Projects

| Project | Description | Skills |
|---------|-------------|--------|
| [NumberProcessorApp_Test](NumberProcessorApp_Test/) | Unit tests for a number processing app with custom stack/queue | JUnit, model/view testing |
| [VehicleApp_Test](VehicleApp_Test/) | Comprehensive MVC tests for an autonomous vehicle app | JUnit, MVC testing, [TestDoc](VehicleApp_Test/Test/TestDoc.md) |
| [CoffeeMaker Mocks & Stubs](CoffeeMakerTest_AddingMocksAndStubs/) | Coffee maker tests using Mockito to stub RecipeBook dependencies | Mockito, mocks, stubs |

## Suggested Order

1. [NumberProcessorApp_Test](NumberProcessorApp_Test/) → 2. [VehicleApp_Test](VehicleApp_Test/) → 3. [CoffeeMaker Mocks & Stubs](CoffeeMakerTest_AddingMocksAndStubs/)

## Getting Started

Open each project in IntelliJ IDEA or Eclipse with JUnit (and Mockito where noted) on the classpath. Run test classes from the `Test/` or `test/` directory. See individual project READMEs for specific test class names and dependencies.
