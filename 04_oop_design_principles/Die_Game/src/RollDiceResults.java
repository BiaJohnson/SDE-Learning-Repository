/**
 The RollDiceResults class contains a method to compare two dice rolling against each other.
 */
public class RollDiceResults {
    /**
     Rolls two dice against each other 1,000 times and counts how often the first die wins.
     @param die1 the first die.
     @param die2 the second die.
     @return the number of times die1 wins.
     */
    public static int returnRollDiceResults(Die die1, Die die2) {
        int totalRolls = 1000; // Number of rolls in the simulation.
        int timesDie1Wins = 0; // Counter for how many times die1 rolls a higher value.
        // Simulate 1000 rolls
        for (int i = 0; i < totalRolls; i++) {
            int rollDie1 = die1.rollDie(); // Roll die1
            int rollDie2 = die2.rollDie(); // Roll die2
            // Check if die1 wins this round
            if (rollDie1 > rollDie2) {
                timesDie1Wins++;
            }
        }
        return timesDie1Wins; // Return the total number of times die1 won.
    }
}