import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * A main class for the PakanonGame.
 * It is responsible for creating objects,
 * connecting objects, and running the game UI.
 *
 * @author Pakanon Pantisawat
 */
public class Main extends Application {
    public static void main(String[] args) {
        // upper limit for secret number in guessing game

        /*int upperBound = 101;
        NumberGame game = new PakanonGame(upperBound);
//		GameConsole ui = new GameConsole();
        GameSolver ui = new GameSolver();
        int solution = ui.play(game);
        System.out.println("play() returned [The last response] : " + solution);
        System.out.println("Your total guess(es) is " + game.getCount());*/

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = getClass().getResource("GuessingUI.fxml");
            assert url != null;
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Guessing Game");
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error loading FXML.");
        }
    }
}
