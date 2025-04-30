/**
 The LoadedDie class represents a die that never rolls a 1.
 It overrides the rollDie method to roll values between 2 and 6.
 */
public class LoadedDie extends Die {
    /**
     @return an integer between 2 and 6.
     */
    @Override
    public int rollDie() {
        // Generate a random value between 2 and 6.
        value = random.nextInt(5) + 2;
        return value;
    }
}