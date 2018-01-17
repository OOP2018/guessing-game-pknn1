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

        boolean isNotCorrect = true;

        System.out.println(game.getMessage());

        int upBound = game.getUpperBound();
        int lowBound = 1;
        int guess = (upBound - lowBound) / 2 + lowBound;
        while (isNotCorrect) {
            System.out.println("My guess: " + guess);
            isNotCorrect = !game.guess(guess);
            String response = game.getMessage();
            System.out.println(response);

            if (response.contains("large")) {
                upBound = guess;
            } else if (response.contains("small")) {
                lowBound = guess;
            }
            guess = (upBound - lowBound) / 2 + lowBound;
        }
        return guess;
    }
}
