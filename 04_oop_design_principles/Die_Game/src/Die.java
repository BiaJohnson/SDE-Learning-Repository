import java.util.Random;
/**
 The Die class represents a standard die.
 */
public class Die {
    protected int value;  // Stores the current roll value of the die.
    protected Random random;  // Random object for generating dice rolls.
    /**
     Constructor initializes the Random object.
     */
    public Die(){
        random = new Random();
    }
    /**
     Rolls the die to generate a random value between 1 and 6.
     @return an integer between 1 and 6.
     */
    public int rollDie(){
        // Generate a random value between 1 and 6.
        value = random.nextInt(6) + 1;
        return value;
    }
}