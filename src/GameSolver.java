
/**
 * An autonomous solver for the guessing game.
 *
 * @author Pakanon Pantisawat
 * @version 2018.01.12
 */
public class GameSolver {

    /**
     * Play the number game and return the solution.
     * The number game must return "small" or "large" in the response
     * to determine if the answer is correct or not.
     *
     * @param game the game object.
     * @return the solution of the game.
     */
    public int play(NumberGame game) {
        System.out.println(game.toString());

        boolean isCorrect = false;

        System.out.println(game.getMessage());

        int upBound = game.getUpperBound();
        int lowBound = 1;
        int guess = upBound / 2 + lowBound;
        while (!isCorrect) {

            isCorrect = game.guess(guess);
            if (isCorrect) continue;

            String response = game.getMessage().toLowerCase();

            if (response.contains("large")) {
                upBound = guess - 1;
            } else if (response.contains("small")) {
                lowBound = guess + 1;
            }

            if (upBound < lowBound) System.exit(0);

            int diff = upBound - lowBound;
            guess = diff / 2 + lowBound;
        }
        return guess;
    }
}
