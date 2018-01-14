/**
 * A main class for the PakanonGame.
 * It is responsible for creating objects,
 * connecting objects, and running the game UI.
 *
 * @author Pakanon Pantisawat
 */
public class Main {
    public static void main(String[] args) {
        // upper limit for secret number in guessing game
        int upperBound = 101;
        NumberGame game = new PakanonGame(upperBound);
//		GameConsole ui = new GameConsole();
        GameSolver ui = new GameSolver();
        int solution = ui.play(game);
        System.out.println("play() returned [The last response] : " + solution);
        System.out.println("Your total guess(es) is " + game.getCount());
    }

}
