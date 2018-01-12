import java.util.Random;

/**
 * guessing game.
 *
 * @author Rommadon Teedo 5810545025
 * @version 2018.01.11
 */
public class GdGame extends NumberGame {
    /**
     * upper bound for secret number
     */
    private int upperBound;
    /**
     * the solution to the game
     */
    private int secret;
    private int count;

    /** count guesses */

    /**
     * Initialize a new default game.
     */
    public GdGame() {
        this(100);
    }

    public GdGame(int upperbound) {
        final int base = 16;
        this.count = 0;
        this.upperBound = upperbound;
        // create the secret number
        long seed = System.nanoTime();
        Random rand = new Random(seed);
        // don't just copy this.
        // random.nextInt(n) returns a random integer between 0 and n-1, inclusive.
        this.secret = rand.nextInt(upperbound) + 1;
        super.setMessage("I'm thinking of a number between 1 and XX");
    }

    /**
     * Evaluate a user's guess.
     *
     * @param number is the user's guess
     * @return true if guess is correct, false otherwise
     */
    public boolean guess(int number) {
        if (number == secret) {

            count++;
            setMessage("Right! The secret is " + secret + "\n" + "The count is " + count);

            return true;
        }
        if (number < 3 * secret / 4) {

            count++;
            setMessage("Woah! Your answer is WAY too small.");
        } else if (number < secret) {

            count++;
            setMessage("Sorry, too small.");
        } else if (number > secret * 4 / 3) {

            count++;
            setMessage("No way! Your answer is WAY too large.");
        } else if (number > secret) {

            count++;
            setMessage("Sorry, too large.");
        }
        return false;
    }

    /**
     * Get the game upper bound.
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * Get the game secret.
     */
    public int getSecret() {
        return secret;
    }

    /**
     * Get the game count.
     */
    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Guess a secret number";
    }
}