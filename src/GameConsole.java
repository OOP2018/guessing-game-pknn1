import java.util.Scanner;

/**
 * Controller class of the game.
 * By using play method, the game can using input from the user
 * and pass to the game logic.
 *
 * @author Pakanon Pantisawat
 */

public class GameConsole {

    /**
     * Play method plays a game using input from a user
     * and pass to the game logic in the Model class.
     *
     * @param game NumberGame object
     * @return the last guess which is correct answer.
     */
	public int play(NumberGame game) {
        Scanner input = new Scanner(System.in);

        System.out.println(game.toString());

        // Determine if correct answer has been guessed.
        boolean isNotCorrect = true;

        System.out.println(game.getMessage());

        int guess = 0;
        while (isNotCorrect) {
            System.out.print("Your guess? ");
            guess = input.nextInt();
            isNotCorrect = !game.guess(guess);
            System.out.println(game.getMessage());
        }
        return guess;
    }
	
}
