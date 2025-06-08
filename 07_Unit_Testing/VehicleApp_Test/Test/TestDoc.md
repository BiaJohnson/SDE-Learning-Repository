
# Test Documentation – Autonomous Vehicle App

## 1. Introduction
This document outlines the tests performed for the Autonomous Vehicle App.

## 2. Test cases For VehicleView

### 2.1 VehicleView Class Description
The VehicleView class Handles all user interface display and formatting:
-	Main menu display and user selection
-	Vehicle details display
-	Turn history visualization
-	Summary reports

### 2.2 Test Cases for VehicleView Class
- testDisplayMainMenu_ValidSelection: Tests the main menu display with a valid vehicle selection, verifying proper menu rendering and vehicle list display.
- testDisplayMainMenu_Exit: Tests the exit functionality of the main menu, ensuring proper termination when user selects exit option.
- testDisplayMainMenu_InvalidInput: Tests the main menu's handling of invalid input, verifying appropriate error messages and recovery.
- testDisplayVehicleDetails: Tests the display of detailed vehicle information, ensuring all vehicle attributes are properly shown.
- testDisplayFinalDirectionWithTurns_WithTurns: Tests the display of final direction when turns are present, verifying turn history and final heading.
- testDisplayFinalDirectionWithTurns_NoTurns: Tests the display of final direction when no turns are made, verifying appropriate "No turns" message.
- testDisplaySummary_WithMultipleVehicles: Tests summary display with multiple vehicles, verifying correct display of each vehicle's information and turn history.
- testDisplaySummary_EmptyTurnHistory: Tests summary display when turn history is empty, verifying proper handling of vehicles with no turns.
- testDisplayMainMenu_OutOfRangeSelection: Tests menu handling of out-of-range selections, verifying appropriate error messages and recovery.
- testDisplayMainMenu_NegativeNumberInput: Tests menu handling of negative number inputs, ensuring proper error handling and recovery.
- testDisplaySummary_MixedTurnLists: Tests summary display with mixed turn histories (some vehicles with turns, others without), verifying correct formatting.
- testDisplaySummary_AllEmptyTurnLists: Tests summary display when all vehicles have empty turn histories, verifying proper "None" messages for all vehicles.

### 2.2 Results for VehicleViewTest

![ConsoleView Test Results](TestResults/VehicleViewTest.png)

1.	Code Optimization Suggestion
-	In the turn history display logic, there's an opportunity to optimize the code by removing a redundant conditional check
-	The current code checks if (turnList.length() > 0) before removing trailing comma and space
-	This check appears unnecessary because:
     -	The code block only executes when !turns.isEmpty()
     -	The StringBuilder turnList will always have content due to the for-loop appending characters
-	Suggestion: Consider removing this check to simplify the code while maintaining the same functionality

```
The simplified ode could be:
// Display the turn history
System.out.println("Turn History: ");
if (turns.isEmpty()) {
    System.out.println("No turns made.");
} else {
    StringBuilder turnList = new StringBuilder();
    for (Character turn : turns) {
        turnList.append(turn).append(", ");
    }
    // Remove the trailing comma and space
    turnList.setLength(turnList.length() - 2);
    System.out.println(turnList.toString());
}
```

--------------------------------------------------------------------------

## 3. Test cases For AutonomousVehicleApp

### 3.1 AutonomousVehicleApp Class Description

This class coordinates the interaction between the controller, view, and model components:
- Select from multiple autonomous vehicles
- Input directional commands (L for left, R for right)
- View the final direction and turn history for each vehicle
- See a summary of all vehicles and their directions upon exit

### 3.2 Test Cases for AutonomousVehicleAppTest
- testMainFlow_MultipleVehicleSelections: Tests the comprehensive flow of selecting and controlling multiple vehicles (Tesla, Toyota, and GM). Verifies that the system correctly processes sequential commands for each vehicle, including turns and stops, and maintains proper state management across vehicle switches.
- testMainFlow_SingleVehicleSelection: Tests the detailed control flow for a single vehicle (Tesla), verifying the system's ability to handle multiple consecutive commands (left turns, right turns, and stop) for the same vehicle, ensuring consistent behavior and proper command processing.
- testMainFlow_ImmediateExit: Tests the system's exit functionality when user chooses to exit immediately without performing any vehicle operations, verifying proper shutdown sequence and exit message display.
- testMainFlow_InvalidInput: Tests the system's error handling and recovery mechanisms when receiving invalid input, verifying that the system properly displays error messages, maintains stability, and allows the user to continue with valid inputs after an error occurs.

### 3.3 Results for AutonomousVehicleAppTest

![ConsoleView Test Results](TestResults/AutonomousVehicleAppTest.png)

--------------------------------------------------------------------------

## 4. Test cases For AutonomousVehicle covering GMVehicle, TeslaVehicle and ToyotaVehicle

### 4.1 AutonomousVehicle, GMVehicle, TeslaVehicle and ToyotaVehicle Class Description

1. AutonomousVehicleApp: This class serves as the parent for specific vehicle manufacturer implementations:
- Efficient direction calculation
- Memory-optimized data structures
- Support for multiple direction command formats

2. GMVehicle: Constructs a new GM autonomous vehicle with the specified properties:
- autonomyLevel: The level of autonomy (1-5) where 5 is fully autonomous
- model: The model name of the GM vehicle
- color: The color of the vehicle
- vehicleType: The type of vehicle (must be one of: "pod", "robotaxi", "car")
- @throws IllegalArgumentException if the vehicle type is invalid

3. TeslaVehicle: Constructs a new Tesla autonomous vehicle with the specified properties
- autonomyLevel: The level of autonomy (1-5) where 5 is fully autonomous
- model: The model name of the Tesla vehicle (e.g., "Model S", "Model 3")
- color: The color of the vehicle

4. ToyotaVehicle: Constructs a new Toyota autonomous vehicle with the specified properties:
- autonomyLevel: The level of autonomy (1-5) where 5 is fully autonomous
- model The model: name of the Toyota vehicle
- color: The color of the vehicle

### 4.2 Test cases for AutonomousVehicle, GMVehicle, TeslaVehicle and ToyotaVehicle Class

1. Constructor Tests
- TeslaConstructorTest: Tests Tesla vehicle initialization, verifying correct setting of autonomy level, make, model, color, and default direction.
- GMTConstructorTest: Tests GM vehicle initialization, verifying correct setting of properties including the automatic GM make assignment and vehicle type.
- ToyotaConstructorWeekdayTest: Tests Toyota vehicle initialization on weekdays, verifying Lyft availability is false on weekdays.
- ToyotaConstructorSundayTest: Tests Toyota vehicle initialization on Sundays, verifying Lyft availability is true on Sundays.

2. Validation Tests
- TeslaConstructorInvalidAutonomyLevelLowTest: Verifies constructor rejects autonomy levels below minimum allowed value.
- TeslaConstructorInvalidAutonomyLevelHighTest: Verifies constructor rejects autonomy levels above maximum allowed value.
- GMTConstructorInvalidAutonomyLevelLowTest: Verifies GM constructor rejects autonomy levels below minimum.
- GMTConstructorInvalidAutonomyLevelHighTest: Verifies GM constructor rejects autonomy levels above maximum.
- ToyotaConstructorInvalidAutonomyLevelLowTest: Verifies Toyota constructor rejects autonomy levels below minimum.
- ToyotaConstructorInvalidAutonomyLevelHighTest: Verifies Toyota constructor rejects autonomy levels above maximum.

3. Direction Calculation Tests
- FinalDirectionCharArrayTest: Tests direction calculation using character array input for turns.
- FinalDirectionStringArrayTest: Tests direction calculation using string array input for turns.
- FinalDirectionFullCircleTest: Verifies that four left turns return vehicle to original direction.
- FinalDirectionEmptyArrayTest: Verifies that no turns maintains the initial direction.
- FinalDirectionMultipleTurnsTest: Tests multiple turn sequences for correct final direction calculation.

4. Vehicle Type Validation
- GMTestConstructorInvalidVehicleType: Verifies GM constructor rejects invalid vehicle types.

### 4.3 Results for AutonomousVehicleTest

![ConsoleView Test Results](TestResults/AutonomousVehicleTest.png)

--------------------------------------------------------------------------

## 5. Test cases For VehicleController

### 5.1 VehicleController Class Description

Controller component of the MVC pattern for the Autonomous Vehicle System. It Manages vehicle data and processes user input for vehicle directions.
Features include:
- Strict input validation for turn commands.
- Turn history tracking for each vehicle.
- Efficient vehicle data management.

### 5.2 Test cases for VehicleControllerTest:

1. Vehicle Management Tests
- testAddMultipleVehicles: Tests the addition of multiple vehicle types (Tesla, Toyota, GM) to the controller, verifying proper storage and retrieval capabilities.
- testGetAllVehicles: Tests retrieval of all vehicles, verifying correct order and content of the returned vehicle list.
- testGetAllVehiclesEmptyList: Tests retrieval of vehicles when controller is empty, verifying proper handling of empty state.
- testGetVehicle: Tests retrieval of specific vehicles by index, ensuring correct vehicles are returned at their respective positions.

2. Error Handling Tests
- testGetVehicleInvalidIndex: Tests retrieval of vehicle with invalid index, verifying null return for out-of-bounds access.
- testGetVehicleNegativeIndex: Tests retrieval of vehicle with negative indices, verifying null return for negative index values.
- testGetTurnHistoryInvalidIndex: Tests retrieval of turn history with invalid vehicle index, verifying empty list return.
- testGetTurnHistoryNegativeIndex: Tests retrieval of turn history with negative indices, verifying proper handling of invalid inputs.

3. Direction Processing Tests
- testProcessUserDirectionsAndHistory: Tests processing of vehicle direction commands and history tracking, verifying:
  - Correct final direction calculation 
  - Proper recording of turn history 
  - Accurate sequence of recorded turns
- testProcessUserDirectionsInvalidIndex: Tests direction processing for invalid vehicle index, verifying default 'N' direction return.
- testProcessUserDirectionsCaseInsensitive: Tests case-insensitive processing of direction commands, ensuring:
  - Proper handling of lowercase inputs 
  - Correct conversion to uppercase in history 
  - Accurate turn recording regardless of input case

### 5.3 Results for and VehicleControllerTest

![ConsoleView Test Results](TestResults/VehicleControllerTest.png)

--------------------------------------------------------------------------
