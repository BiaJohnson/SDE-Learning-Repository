/**
 The LoadDieGame class runs the dice rolling simulation.
 */
public class LoadDieGame {
    public static void main(String[] args) {
        // Die vs Die (both fair dice)
        int dieVSdie = RollDiceResults.returnRollDiceResults(new Die(), new Die());
        System.out.println("Die vs Die: Die1 wins " + dieVSdie + " times");
        // Die vs LoadedDie (fair die vs loaded die)
        int dieVSloadedDie = RollDiceResults.returnRollDiceResults(new Die(), new LoadedDie());
        System.out.println("Die vs Loaded Die: Die1 wins " + dieVSloadedDie + " times");
    }
}