import java.util.Random;

/**
 * Logic part of guessing game.
 *
 * @author Pakanon Pantisawat
 * @version 2018.01.12
 */

public class GuessingGame extends NumberGame {
    /**
     * secret number upper bound.
     */
    private int upperBound;

    /**
     * the solution number of the game
     */
    private int secret;

    /**
     * the guessing time counting
     */
    private int guessCount;

    public GuessingGame() {
        this(110);
    }

    /**
     * Initialize new game.
     *
     * @param upperBound maximum value of the secret number. upperBound must be > 1
     */
    GuessingGame(int upperBound) {
        this.guessCount = 0;
        if (upperBound <= 1) {
            System.err.println("Upper bound must be larger than 1.");
            return;
        }
        this.upperBound = upperBound;
        long seed = System.nanoTime();
        Random rand = new Random(seed);
        this.secret = rand.nextInt(upperBound) + 1;
        super.setMessage("I'm thinking of a number between 1 and " + upperBound + ".");
    }

    @Override
    public boolean guess(int answer) {
        guessCount++;
        int diff = Math.abs(answer - secret);

        if (diff == 0) {
            super.setMessage("Oh! Such a miracle.");
            return true;
        }


        String message = "Your guessing is ";

        if (diff > 50) message += "Ridiculously ";
        else if (diff > 40) message += "TOOOOOO ";
        else if (diff > 30) message += "TOOOO ";
        else if (diff > 20) message += "TOO ";
        else if (diff < 3) message += "Oooh! That's a bit ";

        if (answer > secret) message += "large.";
        else if (answer < secret) message += "small.";

        super.setMessage(message);

        return false;
    }

    @Override
    public int getUpperBound() {
        return this.upperBound;
    }

    @Override
    public String toString() {
        return String.format("Guess a secret number between 1 and %d.%n", getUpperBound());
    }

    @Override
    public int getCount() {
        return guessCount;
    }
}
